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

package com.google.cloud.video.livestream.v1;

import static com.google.cloud.video.livestream.v1.LivestreamServiceClient.ListAssetsPagedResponse;
import static com.google.cloud.video.livestream.v1.LivestreamServiceClient.ListChannelsPagedResponse;
import static com.google.cloud.video.livestream.v1.LivestreamServiceClient.ListClipsPagedResponse;
import static com.google.cloud.video.livestream.v1.LivestreamServiceClient.ListDvrSessionsPagedResponse;
import static com.google.cloud.video.livestream.v1.LivestreamServiceClient.ListEventsPagedResponse;
import static com.google.cloud.video.livestream.v1.LivestreamServiceClient.ListInputsPagedResponse;
import static com.google.cloud.video.livestream.v1.LivestreamServiceClient.ListLocationsPagedResponse;

import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.httpjson.GaxHttpJsonProperties;
import com.google.api.gax.httpjson.testing.MockHttpService;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.ApiException;
import com.google.api.gax.rpc.ApiExceptionFactory;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.api.gax.rpc.StatusCode;
import com.google.api.gax.rpc.testing.FakeStatusCode;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
import com.google.cloud.video.livestream.v1.stub.HttpJsonLivestreamServiceStub;
import com.google.common.collect.Lists;
import com.google.longrunning.Operation;
import com.google.protobuf.Any;
import com.google.protobuf.Empty;
import com.google.protobuf.FieldMask;
import com.google.protobuf.Timestamp;
import com.google.rpc.Status;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ExecutionException;
import javax.annotation.Generated;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

@Generated("by gapic-generator-java")
public class LivestreamServiceClientHttpJsonTest {
  private static MockHttpService mockService;
  private static LivestreamServiceClient client;

  @BeforeClass
  public static void startStaticServer() throws IOException {
    mockService =
        new MockHttpService(
            HttpJsonLivestreamServiceStub.getMethodDescriptors(),
            LivestreamServiceSettings.getDefaultEndpoint());
    LivestreamServiceSettings settings =
        LivestreamServiceSettings.newHttpJsonBuilder()
            .setTransportChannelProvider(
                LivestreamServiceSettings.defaultHttpJsonTransportProviderBuilder()
                    .setHttpTransport(mockService)
                    .build())
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = LivestreamServiceClient.create(settings);
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
  public void createChannelTest() throws Exception {
    Channel expectedResponse =
        Channel.newBuilder()
            .setName(ChannelName.of("[PROJECT]", "[LOCATION]", "[CHANNEL]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .addAllInputAttachments(new ArrayList<InputAttachment>())
            .setActiveInput("activeInput-1071817628")
            .setOutput(Channel.Output.newBuilder().build())
            .addAllElementaryStreams(new ArrayList<ElementaryStream>())
            .addAllMuxStreams(new ArrayList<MuxStream>())
            .addAllManifests(new ArrayList<Manifest>())
            .addAllSpriteSheets(new ArrayList<SpriteSheet>())
            .setStreamingError(Status.newBuilder().build())
            .setLogConfig(LogConfig.newBuilder().build())
            .setTimecodeConfig(TimecodeConfig.newBuilder().build())
            .addAllEncryptions(new ArrayList<Encryption>())
            .setInputConfig(InputConfig.newBuilder().build())
            .setRetentionConfig(RetentionConfig.newBuilder().build())
            .addAllStaticOverlays(new ArrayList<StaticOverlay>())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createChannelTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
    Channel channel = Channel.newBuilder().build();
    String channelId = "channelId1461735806";

    Channel actualResponse = client.createChannelAsync(parent, channel, channelId).get();
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
  public void createChannelExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      Channel channel = Channel.newBuilder().build();
      String channelId = "channelId1461735806";
      client.createChannelAsync(parent, channel, channelId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void createChannelTest2() throws Exception {
    Channel expectedResponse =
        Channel.newBuilder()
            .setName(ChannelName.of("[PROJECT]", "[LOCATION]", "[CHANNEL]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .addAllInputAttachments(new ArrayList<InputAttachment>())
            .setActiveInput("activeInput-1071817628")
            .setOutput(Channel.Output.newBuilder().build())
            .addAllElementaryStreams(new ArrayList<ElementaryStream>())
            .addAllMuxStreams(new ArrayList<MuxStream>())
            .addAllManifests(new ArrayList<Manifest>())
            .addAllSpriteSheets(new ArrayList<SpriteSheet>())
            .setStreamingError(Status.newBuilder().build())
            .setLogConfig(LogConfig.newBuilder().build())
            .setTimecodeConfig(TimecodeConfig.newBuilder().build())
            .addAllEncryptions(new ArrayList<Encryption>())
            .setInputConfig(InputConfig.newBuilder().build())
            .setRetentionConfig(RetentionConfig.newBuilder().build())
            .addAllStaticOverlays(new ArrayList<StaticOverlay>())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createChannelTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    String parent = "projects/project-5833/locations/location-5833";
    Channel channel = Channel.newBuilder().build();
    String channelId = "channelId1461735806";

    Channel actualResponse = client.createChannelAsync(parent, channel, channelId).get();
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
  public void createChannelExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-5833/locations/location-5833";
      Channel channel = Channel.newBuilder().build();
      String channelId = "channelId1461735806";
      client.createChannelAsync(parent, channel, channelId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void listChannelsTest() throws Exception {
    Channel responsesElement = Channel.newBuilder().build();
    ListChannelsResponse expectedResponse =
        ListChannelsResponse.newBuilder()
            .setNextPageToken("")
            .addAllChannels(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

    ListChannelsPagedResponse pagedListResponse = client.listChannels(parent);

    List<Channel> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getChannelsList().get(0), resources.get(0));

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
  public void listChannelsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      client.listChannels(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listChannelsTest2() throws Exception {
    Channel responsesElement = Channel.newBuilder().build();
    ListChannelsResponse expectedResponse =
        ListChannelsResponse.newBuilder()
            .setNextPageToken("")
            .addAllChannels(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "projects/project-5833/locations/location-5833";

    ListChannelsPagedResponse pagedListResponse = client.listChannels(parent);

    List<Channel> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getChannelsList().get(0), resources.get(0));

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
  public void listChannelsExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-5833/locations/location-5833";
      client.listChannels(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getChannelTest() throws Exception {
    Channel expectedResponse =
        Channel.newBuilder()
            .setName(ChannelName.of("[PROJECT]", "[LOCATION]", "[CHANNEL]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .addAllInputAttachments(new ArrayList<InputAttachment>())
            .setActiveInput("activeInput-1071817628")
            .setOutput(Channel.Output.newBuilder().build())
            .addAllElementaryStreams(new ArrayList<ElementaryStream>())
            .addAllMuxStreams(new ArrayList<MuxStream>())
            .addAllManifests(new ArrayList<Manifest>())
            .addAllSpriteSheets(new ArrayList<SpriteSheet>())
            .setStreamingError(Status.newBuilder().build())
            .setLogConfig(LogConfig.newBuilder().build())
            .setTimecodeConfig(TimecodeConfig.newBuilder().build())
            .addAllEncryptions(new ArrayList<Encryption>())
            .setInputConfig(InputConfig.newBuilder().build())
            .setRetentionConfig(RetentionConfig.newBuilder().build())
            .addAllStaticOverlays(new ArrayList<StaticOverlay>())
            .build();
    mockService.addResponse(expectedResponse);

    ChannelName name = ChannelName.of("[PROJECT]", "[LOCATION]", "[CHANNEL]");

    Channel actualResponse = client.getChannel(name);
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
  public void getChannelExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      ChannelName name = ChannelName.of("[PROJECT]", "[LOCATION]", "[CHANNEL]");
      client.getChannel(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getChannelTest2() throws Exception {
    Channel expectedResponse =
        Channel.newBuilder()
            .setName(ChannelName.of("[PROJECT]", "[LOCATION]", "[CHANNEL]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .addAllInputAttachments(new ArrayList<InputAttachment>())
            .setActiveInput("activeInput-1071817628")
            .setOutput(Channel.Output.newBuilder().build())
            .addAllElementaryStreams(new ArrayList<ElementaryStream>())
            .addAllMuxStreams(new ArrayList<MuxStream>())
            .addAllManifests(new ArrayList<Manifest>())
            .addAllSpriteSheets(new ArrayList<SpriteSheet>())
            .setStreamingError(Status.newBuilder().build())
            .setLogConfig(LogConfig.newBuilder().build())
            .setTimecodeConfig(TimecodeConfig.newBuilder().build())
            .addAllEncryptions(new ArrayList<Encryption>())
            .setInputConfig(InputConfig.newBuilder().build())
            .setRetentionConfig(RetentionConfig.newBuilder().build())
            .addAllStaticOverlays(new ArrayList<StaticOverlay>())
            .build();
    mockService.addResponse(expectedResponse);

    String name = "projects/project-3296/locations/location-3296/channels/channel-3296";

    Channel actualResponse = client.getChannel(name);
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
  public void getChannelExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "projects/project-3296/locations/location-3296/channels/channel-3296";
      client.getChannel(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteChannelTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteChannelTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    ChannelName name = ChannelName.of("[PROJECT]", "[LOCATION]", "[CHANNEL]");

    client.deleteChannelAsync(name).get();

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
  public void deleteChannelExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      ChannelName name = ChannelName.of("[PROJECT]", "[LOCATION]", "[CHANNEL]");
      client.deleteChannelAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void deleteChannelTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteChannelTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    String name = "projects/project-3296/locations/location-3296/channels/channel-3296";

    client.deleteChannelAsync(name).get();

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
  public void deleteChannelExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "projects/project-3296/locations/location-3296/channels/channel-3296";
      client.deleteChannelAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void updateChannelTest() throws Exception {
    Channel expectedResponse =
        Channel.newBuilder()
            .setName(ChannelName.of("[PROJECT]", "[LOCATION]", "[CHANNEL]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .addAllInputAttachments(new ArrayList<InputAttachment>())
            .setActiveInput("activeInput-1071817628")
            .setOutput(Channel.Output.newBuilder().build())
            .addAllElementaryStreams(new ArrayList<ElementaryStream>())
            .addAllMuxStreams(new ArrayList<MuxStream>())
            .addAllManifests(new ArrayList<Manifest>())
            .addAllSpriteSheets(new ArrayList<SpriteSheet>())
            .setStreamingError(Status.newBuilder().build())
            .setLogConfig(LogConfig.newBuilder().build())
            .setTimecodeConfig(TimecodeConfig.newBuilder().build())
            .addAllEncryptions(new ArrayList<Encryption>())
            .setInputConfig(InputConfig.newBuilder().build())
            .setRetentionConfig(RetentionConfig.newBuilder().build())
            .addAllStaticOverlays(new ArrayList<StaticOverlay>())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("updateChannelTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    Channel channel =
        Channel.newBuilder()
            .setName(ChannelName.of("[PROJECT]", "[LOCATION]", "[CHANNEL]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .addAllInputAttachments(new ArrayList<InputAttachment>())
            .setActiveInput("activeInput-1071817628")
            .setOutput(Channel.Output.newBuilder().build())
            .addAllElementaryStreams(new ArrayList<ElementaryStream>())
            .addAllMuxStreams(new ArrayList<MuxStream>())
            .addAllManifests(new ArrayList<Manifest>())
            .addAllSpriteSheets(new ArrayList<SpriteSheet>())
            .setStreamingError(Status.newBuilder().build())
            .setLogConfig(LogConfig.newBuilder().build())
            .setTimecodeConfig(TimecodeConfig.newBuilder().build())
            .addAllEncryptions(new ArrayList<Encryption>())
            .setInputConfig(InputConfig.newBuilder().build())
            .setRetentionConfig(RetentionConfig.newBuilder().build())
            .addAllStaticOverlays(new ArrayList<StaticOverlay>())
            .build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    Channel actualResponse = client.updateChannelAsync(channel, updateMask).get();
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
  public void updateChannelExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      Channel channel =
          Channel.newBuilder()
              .setName(ChannelName.of("[PROJECT]", "[LOCATION]", "[CHANNEL]").toString())
              .setCreateTime(Timestamp.newBuilder().build())
              .setUpdateTime(Timestamp.newBuilder().build())
              .putAllLabels(new HashMap<String, String>())
              .addAllInputAttachments(new ArrayList<InputAttachment>())
              .setActiveInput("activeInput-1071817628")
              .setOutput(Channel.Output.newBuilder().build())
              .addAllElementaryStreams(new ArrayList<ElementaryStream>())
              .addAllMuxStreams(new ArrayList<MuxStream>())
              .addAllManifests(new ArrayList<Manifest>())
              .addAllSpriteSheets(new ArrayList<SpriteSheet>())
              .setStreamingError(Status.newBuilder().build())
              .setLogConfig(LogConfig.newBuilder().build())
              .setTimecodeConfig(TimecodeConfig.newBuilder().build())
              .addAllEncryptions(new ArrayList<Encryption>())
              .setInputConfig(InputConfig.newBuilder().build())
              .setRetentionConfig(RetentionConfig.newBuilder().build())
              .addAllStaticOverlays(new ArrayList<StaticOverlay>())
              .build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateChannelAsync(channel, updateMask).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void startChannelTest() throws Exception {
    ChannelOperationResponse expectedResponse = ChannelOperationResponse.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("startChannelTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    ChannelName name = ChannelName.of("[PROJECT]", "[LOCATION]", "[CHANNEL]");

    ChannelOperationResponse actualResponse = client.startChannelAsync(name).get();
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
  public void startChannelExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      ChannelName name = ChannelName.of("[PROJECT]", "[LOCATION]", "[CHANNEL]");
      client.startChannelAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void startChannelTest2() throws Exception {
    ChannelOperationResponse expectedResponse = ChannelOperationResponse.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("startChannelTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    String name = "projects/project-3296/locations/location-3296/channels/channel-3296";

    ChannelOperationResponse actualResponse = client.startChannelAsync(name).get();
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
  public void startChannelExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "projects/project-3296/locations/location-3296/channels/channel-3296";
      client.startChannelAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void stopChannelTest() throws Exception {
    ChannelOperationResponse expectedResponse = ChannelOperationResponse.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("stopChannelTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    ChannelName name = ChannelName.of("[PROJECT]", "[LOCATION]", "[CHANNEL]");

    ChannelOperationResponse actualResponse = client.stopChannelAsync(name).get();
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
  public void stopChannelExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      ChannelName name = ChannelName.of("[PROJECT]", "[LOCATION]", "[CHANNEL]");
      client.stopChannelAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void stopChannelTest2() throws Exception {
    ChannelOperationResponse expectedResponse = ChannelOperationResponse.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("stopChannelTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    String name = "projects/project-3296/locations/location-3296/channels/channel-3296";

    ChannelOperationResponse actualResponse = client.stopChannelAsync(name).get();
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
  public void stopChannelExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "projects/project-3296/locations/location-3296/channels/channel-3296";
      client.stopChannelAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void createInputTest() throws Exception {
    Input expectedResponse =
        Input.newBuilder()
            .setName(InputName.of("[PROJECT]", "[LOCATION]", "[INPUT]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setUri("uri116076")
            .setPreprocessingConfig(PreprocessingConfig.newBuilder().build())
            .setSecurityRules(Input.SecurityRule.newBuilder().build())
            .setInputStreamProperty(InputStreamProperty.newBuilder().build())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createInputTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
    Input input = Input.newBuilder().build();
    String inputId = "inputId1954846341";

    Input actualResponse = client.createInputAsync(parent, input, inputId).get();
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
  public void createInputExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      Input input = Input.newBuilder().build();
      String inputId = "inputId1954846341";
      client.createInputAsync(parent, input, inputId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void createInputTest2() throws Exception {
    Input expectedResponse =
        Input.newBuilder()
            .setName(InputName.of("[PROJECT]", "[LOCATION]", "[INPUT]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setUri("uri116076")
            .setPreprocessingConfig(PreprocessingConfig.newBuilder().build())
            .setSecurityRules(Input.SecurityRule.newBuilder().build())
            .setInputStreamProperty(InputStreamProperty.newBuilder().build())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createInputTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    String parent = "projects/project-5833/locations/location-5833";
    Input input = Input.newBuilder().build();
    String inputId = "inputId1954846341";

    Input actualResponse = client.createInputAsync(parent, input, inputId).get();
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
  public void createInputExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-5833/locations/location-5833";
      Input input = Input.newBuilder().build();
      String inputId = "inputId1954846341";
      client.createInputAsync(parent, input, inputId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void listInputsTest() throws Exception {
    Input responsesElement = Input.newBuilder().build();
    ListInputsResponse expectedResponse =
        ListInputsResponse.newBuilder()
            .setNextPageToken("")
            .addAllInputs(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

    ListInputsPagedResponse pagedListResponse = client.listInputs(parent);

    List<Input> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getInputsList().get(0), resources.get(0));

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
  public void listInputsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      client.listInputs(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listInputsTest2() throws Exception {
    Input responsesElement = Input.newBuilder().build();
    ListInputsResponse expectedResponse =
        ListInputsResponse.newBuilder()
            .setNextPageToken("")
            .addAllInputs(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "projects/project-5833/locations/location-5833";

    ListInputsPagedResponse pagedListResponse = client.listInputs(parent);

    List<Input> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getInputsList().get(0), resources.get(0));

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
  public void listInputsExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-5833/locations/location-5833";
      client.listInputs(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getInputTest() throws Exception {
    Input expectedResponse =
        Input.newBuilder()
            .setName(InputName.of("[PROJECT]", "[LOCATION]", "[INPUT]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setUri("uri116076")
            .setPreprocessingConfig(PreprocessingConfig.newBuilder().build())
            .setSecurityRules(Input.SecurityRule.newBuilder().build())
            .setInputStreamProperty(InputStreamProperty.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    InputName name = InputName.of("[PROJECT]", "[LOCATION]", "[INPUT]");

    Input actualResponse = client.getInput(name);
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
  public void getInputExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      InputName name = InputName.of("[PROJECT]", "[LOCATION]", "[INPUT]");
      client.getInput(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getInputTest2() throws Exception {
    Input expectedResponse =
        Input.newBuilder()
            .setName(InputName.of("[PROJECT]", "[LOCATION]", "[INPUT]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setUri("uri116076")
            .setPreprocessingConfig(PreprocessingConfig.newBuilder().build())
            .setSecurityRules(Input.SecurityRule.newBuilder().build())
            .setInputStreamProperty(InputStreamProperty.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    String name = "projects/project-1641/locations/location-1641/inputs/input-1641";

    Input actualResponse = client.getInput(name);
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
  public void getInputExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "projects/project-1641/locations/location-1641/inputs/input-1641";
      client.getInput(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteInputTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteInputTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    InputName name = InputName.of("[PROJECT]", "[LOCATION]", "[INPUT]");

    client.deleteInputAsync(name).get();

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
  public void deleteInputExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      InputName name = InputName.of("[PROJECT]", "[LOCATION]", "[INPUT]");
      client.deleteInputAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void deleteInputTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteInputTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    String name = "projects/project-1641/locations/location-1641/inputs/input-1641";

    client.deleteInputAsync(name).get();

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
  public void deleteInputExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "projects/project-1641/locations/location-1641/inputs/input-1641";
      client.deleteInputAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void updateInputTest() throws Exception {
    Input expectedResponse =
        Input.newBuilder()
            .setName(InputName.of("[PROJECT]", "[LOCATION]", "[INPUT]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setUri("uri116076")
            .setPreprocessingConfig(PreprocessingConfig.newBuilder().build())
            .setSecurityRules(Input.SecurityRule.newBuilder().build())
            .setInputStreamProperty(InputStreamProperty.newBuilder().build())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("updateInputTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    Input input =
        Input.newBuilder()
            .setName(InputName.of("[PROJECT]", "[LOCATION]", "[INPUT]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setUri("uri116076")
            .setPreprocessingConfig(PreprocessingConfig.newBuilder().build())
            .setSecurityRules(Input.SecurityRule.newBuilder().build())
            .setInputStreamProperty(InputStreamProperty.newBuilder().build())
            .build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    Input actualResponse = client.updateInputAsync(input, updateMask).get();
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
  public void updateInputExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      Input input =
          Input.newBuilder()
              .setName(InputName.of("[PROJECT]", "[LOCATION]", "[INPUT]").toString())
              .setCreateTime(Timestamp.newBuilder().build())
              .setUpdateTime(Timestamp.newBuilder().build())
              .putAllLabels(new HashMap<String, String>())
              .setUri("uri116076")
              .setPreprocessingConfig(PreprocessingConfig.newBuilder().build())
              .setSecurityRules(Input.SecurityRule.newBuilder().build())
              .setInputStreamProperty(InputStreamProperty.newBuilder().build())
              .build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateInputAsync(input, updateMask).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void createEventTest() throws Exception {
    Event expectedResponse =
        Event.newBuilder()
            .setName(EventName.of("[PROJECT]", "[LOCATION]", "[CHANNEL]", "[EVENT]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setExecuteNow(true)
            .setExecutionTime(Timestamp.newBuilder().build())
            .setError(Status.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    ChannelName parent = ChannelName.of("[PROJECT]", "[LOCATION]", "[CHANNEL]");
    Event event = Event.newBuilder().build();
    String eventId = "eventId-1376502443";

    Event actualResponse = client.createEvent(parent, event, eventId);
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
  public void createEventExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      ChannelName parent = ChannelName.of("[PROJECT]", "[LOCATION]", "[CHANNEL]");
      Event event = Event.newBuilder().build();
      String eventId = "eventId-1376502443";
      client.createEvent(parent, event, eventId);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createEventTest2() throws Exception {
    Event expectedResponse =
        Event.newBuilder()
            .setName(EventName.of("[PROJECT]", "[LOCATION]", "[CHANNEL]", "[EVENT]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setExecuteNow(true)
            .setExecutionTime(Timestamp.newBuilder().build())
            .setError(Status.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "projects/project-367/locations/location-367/channels/channel-367";
    Event event = Event.newBuilder().build();
    String eventId = "eventId-1376502443";

    Event actualResponse = client.createEvent(parent, event, eventId);
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
  public void createEventExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-367/locations/location-367/channels/channel-367";
      Event event = Event.newBuilder().build();
      String eventId = "eventId-1376502443";
      client.createEvent(parent, event, eventId);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listEventsTest() throws Exception {
    Event responsesElement = Event.newBuilder().build();
    ListEventsResponse expectedResponse =
        ListEventsResponse.newBuilder()
            .setNextPageToken("")
            .addAllEvents(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    ChannelName parent = ChannelName.of("[PROJECT]", "[LOCATION]", "[CHANNEL]");

    ListEventsPagedResponse pagedListResponse = client.listEvents(parent);

    List<Event> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getEventsList().get(0), resources.get(0));

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
  public void listEventsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      ChannelName parent = ChannelName.of("[PROJECT]", "[LOCATION]", "[CHANNEL]");
      client.listEvents(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listEventsTest2() throws Exception {
    Event responsesElement = Event.newBuilder().build();
    ListEventsResponse expectedResponse =
        ListEventsResponse.newBuilder()
            .setNextPageToken("")
            .addAllEvents(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "projects/project-367/locations/location-367/channels/channel-367";

    ListEventsPagedResponse pagedListResponse = client.listEvents(parent);

    List<Event> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getEventsList().get(0), resources.get(0));

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
  public void listEventsExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-367/locations/location-367/channels/channel-367";
      client.listEvents(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getEventTest() throws Exception {
    Event expectedResponse =
        Event.newBuilder()
            .setName(EventName.of("[PROJECT]", "[LOCATION]", "[CHANNEL]", "[EVENT]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setExecuteNow(true)
            .setExecutionTime(Timestamp.newBuilder().build())
            .setError(Status.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    EventName name = EventName.of("[PROJECT]", "[LOCATION]", "[CHANNEL]", "[EVENT]");

    Event actualResponse = client.getEvent(name);
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
  public void getEventExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      EventName name = EventName.of("[PROJECT]", "[LOCATION]", "[CHANNEL]", "[EVENT]");
      client.getEvent(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getEventTest2() throws Exception {
    Event expectedResponse =
        Event.newBuilder()
            .setName(EventName.of("[PROJECT]", "[LOCATION]", "[CHANNEL]", "[EVENT]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setExecuteNow(true)
            .setExecutionTime(Timestamp.newBuilder().build())
            .setError(Status.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    String name =
        "projects/project-4669/locations/location-4669/channels/channel-4669/events/event-4669";

    Event actualResponse = client.getEvent(name);
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
  public void getEventExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "projects/project-4669/locations/location-4669/channels/channel-4669/events/event-4669";
      client.getEvent(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteEventTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockService.addResponse(expectedResponse);

    EventName name = EventName.of("[PROJECT]", "[LOCATION]", "[CHANNEL]", "[EVENT]");

    client.deleteEvent(name);

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
  public void deleteEventExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      EventName name = EventName.of("[PROJECT]", "[LOCATION]", "[CHANNEL]", "[EVENT]");
      client.deleteEvent(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteEventTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockService.addResponse(expectedResponse);

    String name =
        "projects/project-4669/locations/location-4669/channels/channel-4669/events/event-4669";

    client.deleteEvent(name);

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
  public void deleteEventExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "projects/project-4669/locations/location-4669/channels/channel-4669/events/event-4669";
      client.deleteEvent(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listClipsTest() throws Exception {
    Clip responsesElement = Clip.newBuilder().build();
    ListClipsResponse expectedResponse =
        ListClipsResponse.newBuilder()
            .setNextPageToken("")
            .addAllClips(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    ChannelName parent = ChannelName.of("[PROJECT]", "[LOCATION]", "[CHANNEL]");

    ListClipsPagedResponse pagedListResponse = client.listClips(parent);

    List<Clip> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getClipsList().get(0), resources.get(0));

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
  public void listClipsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      ChannelName parent = ChannelName.of("[PROJECT]", "[LOCATION]", "[CHANNEL]");
      client.listClips(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listClipsTest2() throws Exception {
    Clip responsesElement = Clip.newBuilder().build();
    ListClipsResponse expectedResponse =
        ListClipsResponse.newBuilder()
            .setNextPageToken("")
            .addAllClips(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "projects/project-367/locations/location-367/channels/channel-367";

    ListClipsPagedResponse pagedListResponse = client.listClips(parent);

    List<Clip> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getClipsList().get(0), resources.get(0));

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
  public void listClipsExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-367/locations/location-367/channels/channel-367";
      client.listClips(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getClipTest() throws Exception {
    Clip expectedResponse =
        Clip.newBuilder()
            .setName(ClipName.of("[PROJECT]", "[LOCATION]", "[CHANNEL]", "[CLIP]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setStartTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setOutputUri("outputUri-2119300949")
            .setError(Status.newBuilder().build())
            .addAllSlices(new ArrayList<Clip.Slice>())
            .addAllClipManifests(new ArrayList<Clip.ClipManifest>())
            .build();
    mockService.addResponse(expectedResponse);

    ClipName name = ClipName.of("[PROJECT]", "[LOCATION]", "[CHANNEL]", "[CLIP]");

    Clip actualResponse = client.getClip(name);
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
  public void getClipExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      ClipName name = ClipName.of("[PROJECT]", "[LOCATION]", "[CHANNEL]", "[CLIP]");
      client.getClip(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getClipTest2() throws Exception {
    Clip expectedResponse =
        Clip.newBuilder()
            .setName(ClipName.of("[PROJECT]", "[LOCATION]", "[CHANNEL]", "[CLIP]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setStartTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setOutputUri("outputUri-2119300949")
            .setError(Status.newBuilder().build())
            .addAllSlices(new ArrayList<Clip.Slice>())
            .addAllClipManifests(new ArrayList<Clip.ClipManifest>())
            .build();
    mockService.addResponse(expectedResponse);

    String name =
        "projects/project-7679/locations/location-7679/channels/channel-7679/clips/clip-7679";

    Clip actualResponse = client.getClip(name);
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
  public void getClipExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "projects/project-7679/locations/location-7679/channels/channel-7679/clips/clip-7679";
      client.getClip(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createClipTest() throws Exception {
    Clip expectedResponse =
        Clip.newBuilder()
            .setName(ClipName.of("[PROJECT]", "[LOCATION]", "[CHANNEL]", "[CLIP]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setStartTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setOutputUri("outputUri-2119300949")
            .setError(Status.newBuilder().build())
            .addAllSlices(new ArrayList<Clip.Slice>())
            .addAllClipManifests(new ArrayList<Clip.ClipManifest>())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createClipTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    ChannelName parent = ChannelName.of("[PROJECT]", "[LOCATION]", "[CHANNEL]");
    Clip clip = Clip.newBuilder().build();
    String clipId = "clipId-1357703029";

    Clip actualResponse = client.createClipAsync(parent, clip, clipId).get();
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
  public void createClipExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      ChannelName parent = ChannelName.of("[PROJECT]", "[LOCATION]", "[CHANNEL]");
      Clip clip = Clip.newBuilder().build();
      String clipId = "clipId-1357703029";
      client.createClipAsync(parent, clip, clipId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void createClipTest2() throws Exception {
    Clip expectedResponse =
        Clip.newBuilder()
            .setName(ClipName.of("[PROJECT]", "[LOCATION]", "[CHANNEL]", "[CLIP]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setStartTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setOutputUri("outputUri-2119300949")
            .setError(Status.newBuilder().build())
            .addAllSlices(new ArrayList<Clip.Slice>())
            .addAllClipManifests(new ArrayList<Clip.ClipManifest>())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createClipTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    String parent = "projects/project-367/locations/location-367/channels/channel-367";
    Clip clip = Clip.newBuilder().build();
    String clipId = "clipId-1357703029";

    Clip actualResponse = client.createClipAsync(parent, clip, clipId).get();
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
  public void createClipExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-367/locations/location-367/channels/channel-367";
      Clip clip = Clip.newBuilder().build();
      String clipId = "clipId-1357703029";
      client.createClipAsync(parent, clip, clipId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void deleteClipTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteClipTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    ClipName name = ClipName.of("[PROJECT]", "[LOCATION]", "[CHANNEL]", "[CLIP]");

    client.deleteClipAsync(name).get();

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
  public void deleteClipExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      ClipName name = ClipName.of("[PROJECT]", "[LOCATION]", "[CHANNEL]", "[CLIP]");
      client.deleteClipAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void deleteClipTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteClipTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    String name =
        "projects/project-7679/locations/location-7679/channels/channel-7679/clips/clip-7679";

    client.deleteClipAsync(name).get();

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
  public void deleteClipExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "projects/project-7679/locations/location-7679/channels/channel-7679/clips/clip-7679";
      client.deleteClipAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void createDvrSessionTest() throws Exception {
    DvrSession expectedResponse =
        DvrSession.newBuilder()
            .setName(
                DvrSessionName.of("[PROJECT]", "[LOCATION]", "[CHANNEL]", "[DVR_SESSION]")
                    .toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setError(Status.newBuilder().build())
            .addAllDvrManifests(new ArrayList<DvrSession.DvrManifest>())
            .addAllDvrWindows(new ArrayList<DvrSession.DvrWindow>())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createDvrSessionTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    ChannelName parent = ChannelName.of("[PROJECT]", "[LOCATION]", "[CHANNEL]");
    DvrSession dvrSession = DvrSession.newBuilder().build();
    String dvrSessionId = "dvrSessionId120568849";

    DvrSession actualResponse =
        client.createDvrSessionAsync(parent, dvrSession, dvrSessionId).get();
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
  public void createDvrSessionExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      ChannelName parent = ChannelName.of("[PROJECT]", "[LOCATION]", "[CHANNEL]");
      DvrSession dvrSession = DvrSession.newBuilder().build();
      String dvrSessionId = "dvrSessionId120568849";
      client.createDvrSessionAsync(parent, dvrSession, dvrSessionId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void createDvrSessionTest2() throws Exception {
    DvrSession expectedResponse =
        DvrSession.newBuilder()
            .setName(
                DvrSessionName.of("[PROJECT]", "[LOCATION]", "[CHANNEL]", "[DVR_SESSION]")
                    .toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setError(Status.newBuilder().build())
            .addAllDvrManifests(new ArrayList<DvrSession.DvrManifest>())
            .addAllDvrWindows(new ArrayList<DvrSession.DvrWindow>())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createDvrSessionTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    String parent = "projects/project-367/locations/location-367/channels/channel-367";
    DvrSession dvrSession = DvrSession.newBuilder().build();
    String dvrSessionId = "dvrSessionId120568849";

    DvrSession actualResponse =
        client.createDvrSessionAsync(parent, dvrSession, dvrSessionId).get();
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
  public void createDvrSessionExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-367/locations/location-367/channels/channel-367";
      DvrSession dvrSession = DvrSession.newBuilder().build();
      String dvrSessionId = "dvrSessionId120568849";
      client.createDvrSessionAsync(parent, dvrSession, dvrSessionId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void listDvrSessionsTest() throws Exception {
    DvrSession responsesElement = DvrSession.newBuilder().build();
    ListDvrSessionsResponse expectedResponse =
        ListDvrSessionsResponse.newBuilder()
            .setNextPageToken("")
            .addAllDvrSessions(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    ChannelName parent = ChannelName.of("[PROJECT]", "[LOCATION]", "[CHANNEL]");

    ListDvrSessionsPagedResponse pagedListResponse = client.listDvrSessions(parent);

    List<DvrSession> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getDvrSessionsList().get(0), resources.get(0));

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
  public void listDvrSessionsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      ChannelName parent = ChannelName.of("[PROJECT]", "[LOCATION]", "[CHANNEL]");
      client.listDvrSessions(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listDvrSessionsTest2() throws Exception {
    DvrSession responsesElement = DvrSession.newBuilder().build();
    ListDvrSessionsResponse expectedResponse =
        ListDvrSessionsResponse.newBuilder()
            .setNextPageToken("")
            .addAllDvrSessions(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "projects/project-367/locations/location-367/channels/channel-367";

    ListDvrSessionsPagedResponse pagedListResponse = client.listDvrSessions(parent);

    List<DvrSession> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getDvrSessionsList().get(0), resources.get(0));

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
  public void listDvrSessionsExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-367/locations/location-367/channels/channel-367";
      client.listDvrSessions(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getDvrSessionTest() throws Exception {
    DvrSession expectedResponse =
        DvrSession.newBuilder()
            .setName(
                DvrSessionName.of("[PROJECT]", "[LOCATION]", "[CHANNEL]", "[DVR_SESSION]")
                    .toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setError(Status.newBuilder().build())
            .addAllDvrManifests(new ArrayList<DvrSession.DvrManifest>())
            .addAllDvrWindows(new ArrayList<DvrSession.DvrWindow>())
            .build();
    mockService.addResponse(expectedResponse);

    DvrSessionName name =
        DvrSessionName.of("[PROJECT]", "[LOCATION]", "[CHANNEL]", "[DVR_SESSION]");

    DvrSession actualResponse = client.getDvrSession(name);
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
  public void getDvrSessionExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      DvrSessionName name =
          DvrSessionName.of("[PROJECT]", "[LOCATION]", "[CHANNEL]", "[DVR_SESSION]");
      client.getDvrSession(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getDvrSessionTest2() throws Exception {
    DvrSession expectedResponse =
        DvrSession.newBuilder()
            .setName(
                DvrSessionName.of("[PROJECT]", "[LOCATION]", "[CHANNEL]", "[DVR_SESSION]")
                    .toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setError(Status.newBuilder().build())
            .addAllDvrManifests(new ArrayList<DvrSession.DvrManifest>())
            .addAllDvrWindows(new ArrayList<DvrSession.DvrWindow>())
            .build();
    mockService.addResponse(expectedResponse);

    String name =
        "projects/project-7321/locations/location-7321/channels/channel-7321/dvrSessions/dvrSession-7321";

    DvrSession actualResponse = client.getDvrSession(name);
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
  public void getDvrSessionExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "projects/project-7321/locations/location-7321/channels/channel-7321/dvrSessions/dvrSession-7321";
      client.getDvrSession(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteDvrSessionTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteDvrSessionTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    DvrSessionName name =
        DvrSessionName.of("[PROJECT]", "[LOCATION]", "[CHANNEL]", "[DVR_SESSION]");

    client.deleteDvrSessionAsync(name).get();

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
  public void deleteDvrSessionExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      DvrSessionName name =
          DvrSessionName.of("[PROJECT]", "[LOCATION]", "[CHANNEL]", "[DVR_SESSION]");
      client.deleteDvrSessionAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void deleteDvrSessionTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteDvrSessionTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    String name =
        "projects/project-7321/locations/location-7321/channels/channel-7321/dvrSessions/dvrSession-7321";

    client.deleteDvrSessionAsync(name).get();

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
  public void deleteDvrSessionExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "projects/project-7321/locations/location-7321/channels/channel-7321/dvrSessions/dvrSession-7321";
      client.deleteDvrSessionAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void updateDvrSessionTest() throws Exception {
    DvrSession expectedResponse =
        DvrSession.newBuilder()
            .setName(
                DvrSessionName.of("[PROJECT]", "[LOCATION]", "[CHANNEL]", "[DVR_SESSION]")
                    .toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setError(Status.newBuilder().build())
            .addAllDvrManifests(new ArrayList<DvrSession.DvrManifest>())
            .addAllDvrWindows(new ArrayList<DvrSession.DvrWindow>())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("updateDvrSessionTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    DvrSession dvrSession =
        DvrSession.newBuilder()
            .setName(
                DvrSessionName.of("[PROJECT]", "[LOCATION]", "[CHANNEL]", "[DVR_SESSION]")
                    .toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setError(Status.newBuilder().build())
            .addAllDvrManifests(new ArrayList<DvrSession.DvrManifest>())
            .addAllDvrWindows(new ArrayList<DvrSession.DvrWindow>())
            .build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    DvrSession actualResponse = client.updateDvrSessionAsync(dvrSession, updateMask).get();
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
  public void updateDvrSessionExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      DvrSession dvrSession =
          DvrSession.newBuilder()
              .setName(
                  DvrSessionName.of("[PROJECT]", "[LOCATION]", "[CHANNEL]", "[DVR_SESSION]")
                      .toString())
              .setCreateTime(Timestamp.newBuilder().build())
              .setUpdateTime(Timestamp.newBuilder().build())
              .putAllLabels(new HashMap<String, String>())
              .setError(Status.newBuilder().build())
              .addAllDvrManifests(new ArrayList<DvrSession.DvrManifest>())
              .addAllDvrWindows(new ArrayList<DvrSession.DvrWindow>())
              .build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateDvrSessionAsync(dvrSession, updateMask).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void createAssetTest() throws Exception {
    Asset expectedResponse =
        Asset.newBuilder()
            .setName(AssetName.of("[PROJECT]", "[LOCATION]", "[ASSET]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setCrc32C("crc32C-1352400016")
            .setError(Status.newBuilder().build())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createAssetTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
    Asset asset = Asset.newBuilder().build();
    String assetId = "assetId-704776149";

    Asset actualResponse = client.createAssetAsync(parent, asset, assetId).get();
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
  public void createAssetExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      Asset asset = Asset.newBuilder().build();
      String assetId = "assetId-704776149";
      client.createAssetAsync(parent, asset, assetId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void createAssetTest2() throws Exception {
    Asset expectedResponse =
        Asset.newBuilder()
            .setName(AssetName.of("[PROJECT]", "[LOCATION]", "[ASSET]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setCrc32C("crc32C-1352400016")
            .setError(Status.newBuilder().build())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createAssetTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    String parent = "projects/project-5833/locations/location-5833";
    Asset asset = Asset.newBuilder().build();
    String assetId = "assetId-704776149";

    Asset actualResponse = client.createAssetAsync(parent, asset, assetId).get();
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
  public void createAssetExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-5833/locations/location-5833";
      Asset asset = Asset.newBuilder().build();
      String assetId = "assetId-704776149";
      client.createAssetAsync(parent, asset, assetId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void deleteAssetTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteAssetTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    AssetName name = AssetName.of("[PROJECT]", "[LOCATION]", "[ASSET]");

    client.deleteAssetAsync(name).get();

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
  public void deleteAssetExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      AssetName name = AssetName.of("[PROJECT]", "[LOCATION]", "[ASSET]");
      client.deleteAssetAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void deleteAssetTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteAssetTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    String name = "projects/project-3075/locations/location-3075/assets/asset-3075";

    client.deleteAssetAsync(name).get();

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
  public void deleteAssetExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "projects/project-3075/locations/location-3075/assets/asset-3075";
      client.deleteAssetAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void getAssetTest() throws Exception {
    Asset expectedResponse =
        Asset.newBuilder()
            .setName(AssetName.of("[PROJECT]", "[LOCATION]", "[ASSET]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setCrc32C("crc32C-1352400016")
            .setError(Status.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    AssetName name = AssetName.of("[PROJECT]", "[LOCATION]", "[ASSET]");

    Asset actualResponse = client.getAsset(name);
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
  public void getAssetExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      AssetName name = AssetName.of("[PROJECT]", "[LOCATION]", "[ASSET]");
      client.getAsset(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getAssetTest2() throws Exception {
    Asset expectedResponse =
        Asset.newBuilder()
            .setName(AssetName.of("[PROJECT]", "[LOCATION]", "[ASSET]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setCrc32C("crc32C-1352400016")
            .setError(Status.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    String name = "projects/project-3075/locations/location-3075/assets/asset-3075";

    Asset actualResponse = client.getAsset(name);
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
  public void getAssetExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "projects/project-3075/locations/location-3075/assets/asset-3075";
      client.getAsset(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listAssetsTest() throws Exception {
    Asset responsesElement = Asset.newBuilder().build();
    ListAssetsResponse expectedResponse =
        ListAssetsResponse.newBuilder()
            .setNextPageToken("")
            .addAllAssets(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

    ListAssetsPagedResponse pagedListResponse = client.listAssets(parent);

    List<Asset> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getAssetsList().get(0), resources.get(0));

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
  public void listAssetsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      client.listAssets(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listAssetsTest2() throws Exception {
    Asset responsesElement = Asset.newBuilder().build();
    ListAssetsResponse expectedResponse =
        ListAssetsResponse.newBuilder()
            .setNextPageToken("")
            .addAllAssets(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "projects/project-5833/locations/location-5833";

    ListAssetsPagedResponse pagedListResponse = client.listAssets(parent);

    List<Asset> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getAssetsList().get(0), resources.get(0));

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
  public void listAssetsExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-5833/locations/location-5833";
      client.listAssets(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getPoolTest() throws Exception {
    Pool expectedResponse =
        Pool.newBuilder()
            .setName(PoolName.of("[PROJECT]", "[LOCATION]", "[POOL]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setNetworkConfig(Pool.NetworkConfig.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    PoolName name = PoolName.of("[PROJECT]", "[LOCATION]", "[POOL]");

    Pool actualResponse = client.getPool(name);
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
  public void getPoolExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      PoolName name = PoolName.of("[PROJECT]", "[LOCATION]", "[POOL]");
      client.getPool(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getPoolTest2() throws Exception {
    Pool expectedResponse =
        Pool.newBuilder()
            .setName(PoolName.of("[PROJECT]", "[LOCATION]", "[POOL]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setNetworkConfig(Pool.NetworkConfig.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    String name = "projects/project-2637/locations/location-2637/pools/pool-2637";

    Pool actualResponse = client.getPool(name);
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
  public void getPoolExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "projects/project-2637/locations/location-2637/pools/pool-2637";
      client.getPool(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updatePoolTest() throws Exception {
    Pool expectedResponse =
        Pool.newBuilder()
            .setName(PoolName.of("[PROJECT]", "[LOCATION]", "[POOL]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setNetworkConfig(Pool.NetworkConfig.newBuilder().build())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("updatePoolTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    Pool pool =
        Pool.newBuilder()
            .setName(PoolName.of("[PROJECT]", "[LOCATION]", "[POOL]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setNetworkConfig(Pool.NetworkConfig.newBuilder().build())
            .build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    Pool actualResponse = client.updatePoolAsync(pool, updateMask).get();
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
  public void updatePoolExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      Pool pool =
          Pool.newBuilder()
              .setName(PoolName.of("[PROJECT]", "[LOCATION]", "[POOL]").toString())
              .setCreateTime(Timestamp.newBuilder().build())
              .setUpdateTime(Timestamp.newBuilder().build())
              .putAllLabels(new HashMap<String, String>())
              .setNetworkConfig(Pool.NetworkConfig.newBuilder().build())
              .build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updatePoolAsync(pool, updateMask).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void listLocationsTest() throws Exception {
    Location responsesElement = Location.newBuilder().build();
    ListLocationsResponse expectedResponse =
        ListLocationsResponse.newBuilder()
            .setNextPageToken("")
            .addAllLocations(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    ListLocationsRequest request =
        ListLocationsRequest.newBuilder()
            .setName("projects/project-3664")
            .setFilter("filter-1274492040")
            .setPageSize(883849137)
            .setPageToken("pageToken873572522")
            .build();

    ListLocationsPagedResponse pagedListResponse = client.listLocations(request);

    List<Location> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getLocationsList().get(0), resources.get(0));

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
  public void listLocationsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      ListLocationsRequest request =
          ListLocationsRequest.newBuilder()
              .setName("projects/project-3664")
              .setFilter("filter-1274492040")
              .setPageSize(883849137)
              .setPageToken("pageToken873572522")
              .build();
      client.listLocations(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getLocationTest() throws Exception {
    Location expectedResponse =
        Location.newBuilder()
            .setName("name3373707")
            .setLocationId("locationId1541836720")
            .setDisplayName("displayName1714148973")
            .putAllLabels(new HashMap<String, String>())
            .setMetadata(Any.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    GetLocationRequest request =
        GetLocationRequest.newBuilder()
            .setName("projects/project-9062/locations/location-9062")
            .build();

    Location actualResponse = client.getLocation(request);
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
  public void getLocationExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      GetLocationRequest request =
          GetLocationRequest.newBuilder()
              .setName("projects/project-9062/locations/location-9062")
              .build();
      client.getLocation(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
