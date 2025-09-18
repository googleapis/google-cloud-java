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
import com.google.api.gax.grpc.GaxGrpcProperties;
import com.google.api.gax.grpc.testing.LocalChannelProvider;
import com.google.api.gax.grpc.testing.MockGrpcService;
import com.google.api.gax.grpc.testing.MockServiceHelper;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.api.gax.rpc.StatusCode;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
import com.google.common.collect.Lists;
import com.google.longrunning.Operation;
import com.google.protobuf.AbstractMessage;
import com.google.protobuf.Any;
import com.google.protobuf.Empty;
import com.google.protobuf.FieldMask;
import com.google.protobuf.Timestamp;
import com.google.rpc.Status;
import io.grpc.StatusRuntimeException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.ExecutionException;
import javax.annotation.Generated;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

@Generated("by gapic-generator-java")
public class LivestreamServiceClientTest {
  private static MockLivestreamService mockLivestreamService;
  private static MockLocations mockLocations;
  private static MockServiceHelper mockServiceHelper;
  private LocalChannelProvider channelProvider;
  private LivestreamServiceClient client;

  @BeforeClass
  public static void startStaticServer() {
    mockLivestreamService = new MockLivestreamService();
    mockLocations = new MockLocations();
    mockServiceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(),
            Arrays.<MockGrpcService>asList(mockLivestreamService, mockLocations));
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
    LivestreamServiceSettings settings =
        LivestreamServiceSettings.newBuilder()
            .setTransportChannelProvider(channelProvider)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = LivestreamServiceClient.create(settings);
  }

  @After
  public void tearDown() throws Exception {
    client.close();
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
            .addAllDistributionStreams(new ArrayList<DistributionStream>())
            .addAllDistributions(new ArrayList<Distribution>())
            .addAllSpriteSheets(new ArrayList<SpriteSheet>())
            .setStreamingError(Status.newBuilder().build())
            .setLogConfig(LogConfig.newBuilder().build())
            .setTimecodeConfig(TimecodeConfig.newBuilder().build())
            .addAllEncryptions(new ArrayList<Encryption>())
            .setInputConfig(InputConfig.newBuilder().build())
            .setRetentionConfig(RetentionConfig.newBuilder().build())
            .addAllStaticOverlays(new ArrayList<StaticOverlay>())
            .setAutoTranscriptionConfig(AutoTranscriptionConfig.newBuilder().build())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createChannelTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockLivestreamService.addResponse(resultOperation);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
    Channel channel = Channel.newBuilder().build();
    String channelId = "channelId1461735806";

    Channel actualResponse = client.createChannelAsync(parent, channel, channelId).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockLivestreamService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateChannelRequest actualRequest = ((CreateChannelRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(channel, actualRequest.getChannel());
    Assert.assertEquals(channelId, actualRequest.getChannelId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createChannelExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockLivestreamService.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      Channel channel = Channel.newBuilder().build();
      String channelId = "channelId1461735806";
      client.createChannelAsync(parent, channel, channelId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
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
            .addAllDistributionStreams(new ArrayList<DistributionStream>())
            .addAllDistributions(new ArrayList<Distribution>())
            .addAllSpriteSheets(new ArrayList<SpriteSheet>())
            .setStreamingError(Status.newBuilder().build())
            .setLogConfig(LogConfig.newBuilder().build())
            .setTimecodeConfig(TimecodeConfig.newBuilder().build())
            .addAllEncryptions(new ArrayList<Encryption>())
            .setInputConfig(InputConfig.newBuilder().build())
            .setRetentionConfig(RetentionConfig.newBuilder().build())
            .addAllStaticOverlays(new ArrayList<StaticOverlay>())
            .setAutoTranscriptionConfig(AutoTranscriptionConfig.newBuilder().build())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createChannelTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockLivestreamService.addResponse(resultOperation);

    String parent = "parent-995424086";
    Channel channel = Channel.newBuilder().build();
    String channelId = "channelId1461735806";

    Channel actualResponse = client.createChannelAsync(parent, channel, channelId).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockLivestreamService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateChannelRequest actualRequest = ((CreateChannelRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(channel, actualRequest.getChannel());
    Assert.assertEquals(channelId, actualRequest.getChannelId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createChannelExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockLivestreamService.addException(exception);

    try {
      String parent = "parent-995424086";
      Channel channel = Channel.newBuilder().build();
      String channelId = "channelId1461735806";
      client.createChannelAsync(parent, channel, channelId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
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
    mockLivestreamService.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

    ListChannelsPagedResponse pagedListResponse = client.listChannels(parent);

    List<Channel> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getChannelsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockLivestreamService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListChannelsRequest actualRequest = ((ListChannelsRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listChannelsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockLivestreamService.addException(exception);

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
    mockLivestreamService.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListChannelsPagedResponse pagedListResponse = client.listChannels(parent);

    List<Channel> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getChannelsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockLivestreamService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListChannelsRequest actualRequest = ((ListChannelsRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listChannelsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockLivestreamService.addException(exception);

    try {
      String parent = "parent-995424086";
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
            .addAllDistributionStreams(new ArrayList<DistributionStream>())
            .addAllDistributions(new ArrayList<Distribution>())
            .addAllSpriteSheets(new ArrayList<SpriteSheet>())
            .setStreamingError(Status.newBuilder().build())
            .setLogConfig(LogConfig.newBuilder().build())
            .setTimecodeConfig(TimecodeConfig.newBuilder().build())
            .addAllEncryptions(new ArrayList<Encryption>())
            .setInputConfig(InputConfig.newBuilder().build())
            .setRetentionConfig(RetentionConfig.newBuilder().build())
            .addAllStaticOverlays(new ArrayList<StaticOverlay>())
            .setAutoTranscriptionConfig(AutoTranscriptionConfig.newBuilder().build())
            .build();
    mockLivestreamService.addResponse(expectedResponse);

    ChannelName name = ChannelName.of("[PROJECT]", "[LOCATION]", "[CHANNEL]");

    Channel actualResponse = client.getChannel(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockLivestreamService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetChannelRequest actualRequest = ((GetChannelRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getChannelExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockLivestreamService.addException(exception);

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
            .addAllDistributionStreams(new ArrayList<DistributionStream>())
            .addAllDistributions(new ArrayList<Distribution>())
            .addAllSpriteSheets(new ArrayList<SpriteSheet>())
            .setStreamingError(Status.newBuilder().build())
            .setLogConfig(LogConfig.newBuilder().build())
            .setTimecodeConfig(TimecodeConfig.newBuilder().build())
            .addAllEncryptions(new ArrayList<Encryption>())
            .setInputConfig(InputConfig.newBuilder().build())
            .setRetentionConfig(RetentionConfig.newBuilder().build())
            .addAllStaticOverlays(new ArrayList<StaticOverlay>())
            .setAutoTranscriptionConfig(AutoTranscriptionConfig.newBuilder().build())
            .build();
    mockLivestreamService.addResponse(expectedResponse);

    String name = "name3373707";

    Channel actualResponse = client.getChannel(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockLivestreamService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetChannelRequest actualRequest = ((GetChannelRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getChannelExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockLivestreamService.addException(exception);

    try {
      String name = "name3373707";
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
    mockLivestreamService.addResponse(resultOperation);

    ChannelName name = ChannelName.of("[PROJECT]", "[LOCATION]", "[CHANNEL]");

    client.deleteChannelAsync(name).get();

    List<AbstractMessage> actualRequests = mockLivestreamService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteChannelRequest actualRequest = ((DeleteChannelRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteChannelExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockLivestreamService.addException(exception);

    try {
      ChannelName name = ChannelName.of("[PROJECT]", "[LOCATION]", "[CHANNEL]");
      client.deleteChannelAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
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
    mockLivestreamService.addResponse(resultOperation);

    String name = "name3373707";

    client.deleteChannelAsync(name).get();

    List<AbstractMessage> actualRequests = mockLivestreamService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteChannelRequest actualRequest = ((DeleteChannelRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteChannelExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockLivestreamService.addException(exception);

    try {
      String name = "name3373707";
      client.deleteChannelAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
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
            .addAllDistributionStreams(new ArrayList<DistributionStream>())
            .addAllDistributions(new ArrayList<Distribution>())
            .addAllSpriteSheets(new ArrayList<SpriteSheet>())
            .setStreamingError(Status.newBuilder().build())
            .setLogConfig(LogConfig.newBuilder().build())
            .setTimecodeConfig(TimecodeConfig.newBuilder().build())
            .addAllEncryptions(new ArrayList<Encryption>())
            .setInputConfig(InputConfig.newBuilder().build())
            .setRetentionConfig(RetentionConfig.newBuilder().build())
            .addAllStaticOverlays(new ArrayList<StaticOverlay>())
            .setAutoTranscriptionConfig(AutoTranscriptionConfig.newBuilder().build())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("updateChannelTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockLivestreamService.addResponse(resultOperation);

    Channel channel = Channel.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    Channel actualResponse = client.updateChannelAsync(channel, updateMask).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockLivestreamService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateChannelRequest actualRequest = ((UpdateChannelRequest) actualRequests.get(0));

    Assert.assertEquals(channel, actualRequest.getChannel());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateChannelExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockLivestreamService.addException(exception);

    try {
      Channel channel = Channel.newBuilder().build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateChannelAsync(channel, updateMask).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
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
    mockLivestreamService.addResponse(resultOperation);

    ChannelName name = ChannelName.of("[PROJECT]", "[LOCATION]", "[CHANNEL]");

    ChannelOperationResponse actualResponse = client.startChannelAsync(name).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockLivestreamService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    StartChannelRequest actualRequest = ((StartChannelRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void startChannelExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockLivestreamService.addException(exception);

    try {
      ChannelName name = ChannelName.of("[PROJECT]", "[LOCATION]", "[CHANNEL]");
      client.startChannelAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
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
    mockLivestreamService.addResponse(resultOperation);

    String name = "name3373707";

    ChannelOperationResponse actualResponse = client.startChannelAsync(name).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockLivestreamService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    StartChannelRequest actualRequest = ((StartChannelRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void startChannelExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockLivestreamService.addException(exception);

    try {
      String name = "name3373707";
      client.startChannelAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
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
    mockLivestreamService.addResponse(resultOperation);

    ChannelName name = ChannelName.of("[PROJECT]", "[LOCATION]", "[CHANNEL]");

    ChannelOperationResponse actualResponse = client.stopChannelAsync(name).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockLivestreamService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    StopChannelRequest actualRequest = ((StopChannelRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void stopChannelExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockLivestreamService.addException(exception);

    try {
      ChannelName name = ChannelName.of("[PROJECT]", "[LOCATION]", "[CHANNEL]");
      client.stopChannelAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
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
    mockLivestreamService.addResponse(resultOperation);

    String name = "name3373707";

    ChannelOperationResponse actualResponse = client.stopChannelAsync(name).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockLivestreamService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    StopChannelRequest actualRequest = ((StopChannelRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void stopChannelExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockLivestreamService.addException(exception);

    try {
      String name = "name3373707";
      client.stopChannelAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void startDistributionTest() throws Exception {
    ChannelOperationResponse expectedResponse = ChannelOperationResponse.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("startDistributionTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockLivestreamService.addResponse(resultOperation);

    ChannelName name = ChannelName.of("[PROJECT]", "[LOCATION]", "[CHANNEL]");
    List<String> distributionKeys = new ArrayList<>();

    ChannelOperationResponse actualResponse =
        client.startDistributionAsync(name, distributionKeys).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockLivestreamService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    StartDistributionRequest actualRequest = ((StartDistributionRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertEquals(distributionKeys, actualRequest.getDistributionKeysList());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void startDistributionExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockLivestreamService.addException(exception);

    try {
      ChannelName name = ChannelName.of("[PROJECT]", "[LOCATION]", "[CHANNEL]");
      List<String> distributionKeys = new ArrayList<>();
      client.startDistributionAsync(name, distributionKeys).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void startDistributionTest2() throws Exception {
    ChannelOperationResponse expectedResponse = ChannelOperationResponse.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("startDistributionTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockLivestreamService.addResponse(resultOperation);

    String name = "name3373707";
    List<String> distributionKeys = new ArrayList<>();

    ChannelOperationResponse actualResponse =
        client.startDistributionAsync(name, distributionKeys).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockLivestreamService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    StartDistributionRequest actualRequest = ((StartDistributionRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertEquals(distributionKeys, actualRequest.getDistributionKeysList());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void startDistributionExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockLivestreamService.addException(exception);

    try {
      String name = "name3373707";
      List<String> distributionKeys = new ArrayList<>();
      client.startDistributionAsync(name, distributionKeys).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void stopDistributionTest() throws Exception {
    ChannelOperationResponse expectedResponse = ChannelOperationResponse.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("stopDistributionTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockLivestreamService.addResponse(resultOperation);

    ChannelName name = ChannelName.of("[PROJECT]", "[LOCATION]", "[CHANNEL]");
    List<String> distributionKeys = new ArrayList<>();

    ChannelOperationResponse actualResponse =
        client.stopDistributionAsync(name, distributionKeys).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockLivestreamService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    StopDistributionRequest actualRequest = ((StopDistributionRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertEquals(distributionKeys, actualRequest.getDistributionKeysList());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void stopDistributionExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockLivestreamService.addException(exception);

    try {
      ChannelName name = ChannelName.of("[PROJECT]", "[LOCATION]", "[CHANNEL]");
      List<String> distributionKeys = new ArrayList<>();
      client.stopDistributionAsync(name, distributionKeys).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void stopDistributionTest2() throws Exception {
    ChannelOperationResponse expectedResponse = ChannelOperationResponse.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("stopDistributionTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockLivestreamService.addResponse(resultOperation);

    String name = "name3373707";
    List<String> distributionKeys = new ArrayList<>();

    ChannelOperationResponse actualResponse =
        client.stopDistributionAsync(name, distributionKeys).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockLivestreamService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    StopDistributionRequest actualRequest = ((StopDistributionRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertEquals(distributionKeys, actualRequest.getDistributionKeysList());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void stopDistributionExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockLivestreamService.addException(exception);

    try {
      String name = "name3373707";
      List<String> distributionKeys = new ArrayList<>();
      client.stopDistributionAsync(name, distributionKeys).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
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
    mockLivestreamService.addResponse(resultOperation);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
    Input input = Input.newBuilder().build();
    String inputId = "inputId1954846341";

    Input actualResponse = client.createInputAsync(parent, input, inputId).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockLivestreamService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateInputRequest actualRequest = ((CreateInputRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(input, actualRequest.getInput());
    Assert.assertEquals(inputId, actualRequest.getInputId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createInputExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockLivestreamService.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      Input input = Input.newBuilder().build();
      String inputId = "inputId1954846341";
      client.createInputAsync(parent, input, inputId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
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
    mockLivestreamService.addResponse(resultOperation);

    String parent = "parent-995424086";
    Input input = Input.newBuilder().build();
    String inputId = "inputId1954846341";

    Input actualResponse = client.createInputAsync(parent, input, inputId).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockLivestreamService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateInputRequest actualRequest = ((CreateInputRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(input, actualRequest.getInput());
    Assert.assertEquals(inputId, actualRequest.getInputId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createInputExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockLivestreamService.addException(exception);

    try {
      String parent = "parent-995424086";
      Input input = Input.newBuilder().build();
      String inputId = "inputId1954846341";
      client.createInputAsync(parent, input, inputId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
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
    mockLivestreamService.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

    ListInputsPagedResponse pagedListResponse = client.listInputs(parent);

    List<Input> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getInputsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockLivestreamService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListInputsRequest actualRequest = ((ListInputsRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listInputsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockLivestreamService.addException(exception);

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
    mockLivestreamService.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListInputsPagedResponse pagedListResponse = client.listInputs(parent);

    List<Input> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getInputsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockLivestreamService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListInputsRequest actualRequest = ((ListInputsRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listInputsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockLivestreamService.addException(exception);

    try {
      String parent = "parent-995424086";
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
    mockLivestreamService.addResponse(expectedResponse);

    InputName name = InputName.of("[PROJECT]", "[LOCATION]", "[INPUT]");

    Input actualResponse = client.getInput(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockLivestreamService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetInputRequest actualRequest = ((GetInputRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getInputExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockLivestreamService.addException(exception);

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
    mockLivestreamService.addResponse(expectedResponse);

    String name = "name3373707";

    Input actualResponse = client.getInput(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockLivestreamService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetInputRequest actualRequest = ((GetInputRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getInputExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockLivestreamService.addException(exception);

    try {
      String name = "name3373707";
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
    mockLivestreamService.addResponse(resultOperation);

    InputName name = InputName.of("[PROJECT]", "[LOCATION]", "[INPUT]");

    client.deleteInputAsync(name).get();

    List<AbstractMessage> actualRequests = mockLivestreamService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteInputRequest actualRequest = ((DeleteInputRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteInputExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockLivestreamService.addException(exception);

    try {
      InputName name = InputName.of("[PROJECT]", "[LOCATION]", "[INPUT]");
      client.deleteInputAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
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
    mockLivestreamService.addResponse(resultOperation);

    String name = "name3373707";

    client.deleteInputAsync(name).get();

    List<AbstractMessage> actualRequests = mockLivestreamService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteInputRequest actualRequest = ((DeleteInputRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteInputExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockLivestreamService.addException(exception);

    try {
      String name = "name3373707";
      client.deleteInputAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
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
    mockLivestreamService.addResponse(resultOperation);

    Input input = Input.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    Input actualResponse = client.updateInputAsync(input, updateMask).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockLivestreamService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateInputRequest actualRequest = ((UpdateInputRequest) actualRequests.get(0));

    Assert.assertEquals(input, actualRequest.getInput());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateInputExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockLivestreamService.addException(exception);

    try {
      Input input = Input.newBuilder().build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateInputAsync(input, updateMask).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void previewInputTest() throws Exception {
    PreviewInputResponse expectedResponse =
        PreviewInputResponse.newBuilder()
            .setUri("uri116076")
            .setBearerToken("bearerToken1995160344")
            .build();
    mockLivestreamService.addResponse(expectedResponse);

    InputName name = InputName.of("[PROJECT]", "[LOCATION]", "[INPUT]");

    PreviewInputResponse actualResponse = client.previewInput(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockLivestreamService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    PreviewInputRequest actualRequest = ((PreviewInputRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void previewInputExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockLivestreamService.addException(exception);

    try {
      InputName name = InputName.of("[PROJECT]", "[LOCATION]", "[INPUT]");
      client.previewInput(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void previewInputTest2() throws Exception {
    PreviewInputResponse expectedResponse =
        PreviewInputResponse.newBuilder()
            .setUri("uri116076")
            .setBearerToken("bearerToken1995160344")
            .build();
    mockLivestreamService.addResponse(expectedResponse);

    String name = "name3373707";

    PreviewInputResponse actualResponse = client.previewInput(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockLivestreamService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    PreviewInputRequest actualRequest = ((PreviewInputRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void previewInputExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockLivestreamService.addException(exception);

    try {
      String name = "name3373707";
      client.previewInput(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
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
    mockLivestreamService.addResponse(expectedResponse);

    ChannelName parent = ChannelName.of("[PROJECT]", "[LOCATION]", "[CHANNEL]");
    Event event = Event.newBuilder().build();
    String eventId = "eventId-1376502443";

    Event actualResponse = client.createEvent(parent, event, eventId);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockLivestreamService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateEventRequest actualRequest = ((CreateEventRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(event, actualRequest.getEvent());
    Assert.assertEquals(eventId, actualRequest.getEventId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createEventExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockLivestreamService.addException(exception);

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
    mockLivestreamService.addResponse(expectedResponse);

    String parent = "parent-995424086";
    Event event = Event.newBuilder().build();
    String eventId = "eventId-1376502443";

    Event actualResponse = client.createEvent(parent, event, eventId);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockLivestreamService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateEventRequest actualRequest = ((CreateEventRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(event, actualRequest.getEvent());
    Assert.assertEquals(eventId, actualRequest.getEventId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createEventExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockLivestreamService.addException(exception);

    try {
      String parent = "parent-995424086";
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
    mockLivestreamService.addResponse(expectedResponse);

    ChannelName parent = ChannelName.of("[PROJECT]", "[LOCATION]", "[CHANNEL]");

    ListEventsPagedResponse pagedListResponse = client.listEvents(parent);

    List<Event> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getEventsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockLivestreamService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListEventsRequest actualRequest = ((ListEventsRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listEventsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockLivestreamService.addException(exception);

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
    mockLivestreamService.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListEventsPagedResponse pagedListResponse = client.listEvents(parent);

    List<Event> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getEventsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockLivestreamService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListEventsRequest actualRequest = ((ListEventsRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listEventsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockLivestreamService.addException(exception);

    try {
      String parent = "parent-995424086";
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
    mockLivestreamService.addResponse(expectedResponse);

    EventName name = EventName.of("[PROJECT]", "[LOCATION]", "[CHANNEL]", "[EVENT]");

    Event actualResponse = client.getEvent(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockLivestreamService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetEventRequest actualRequest = ((GetEventRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getEventExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockLivestreamService.addException(exception);

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
    mockLivestreamService.addResponse(expectedResponse);

    String name = "name3373707";

    Event actualResponse = client.getEvent(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockLivestreamService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetEventRequest actualRequest = ((GetEventRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getEventExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockLivestreamService.addException(exception);

    try {
      String name = "name3373707";
      client.getEvent(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteEventTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockLivestreamService.addResponse(expectedResponse);

    EventName name = EventName.of("[PROJECT]", "[LOCATION]", "[CHANNEL]", "[EVENT]");

    client.deleteEvent(name);

    List<AbstractMessage> actualRequests = mockLivestreamService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteEventRequest actualRequest = ((DeleteEventRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteEventExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockLivestreamService.addException(exception);

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
    mockLivestreamService.addResponse(expectedResponse);

    String name = "name3373707";

    client.deleteEvent(name);

    List<AbstractMessage> actualRequests = mockLivestreamService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteEventRequest actualRequest = ((DeleteEventRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteEventExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockLivestreamService.addException(exception);

    try {
      String name = "name3373707";
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
    mockLivestreamService.addResponse(expectedResponse);

    ChannelName parent = ChannelName.of("[PROJECT]", "[LOCATION]", "[CHANNEL]");

    ListClipsPagedResponse pagedListResponse = client.listClips(parent);

    List<Clip> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getClipsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockLivestreamService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListClipsRequest actualRequest = ((ListClipsRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listClipsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockLivestreamService.addException(exception);

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
    mockLivestreamService.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListClipsPagedResponse pagedListResponse = client.listClips(parent);

    List<Clip> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getClipsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockLivestreamService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListClipsRequest actualRequest = ((ListClipsRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listClipsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockLivestreamService.addException(exception);

    try {
      String parent = "parent-995424086";
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
    mockLivestreamService.addResponse(expectedResponse);

    ClipName name = ClipName.of("[PROJECT]", "[LOCATION]", "[CHANNEL]", "[CLIP]");

    Clip actualResponse = client.getClip(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockLivestreamService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetClipRequest actualRequest = ((GetClipRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getClipExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockLivestreamService.addException(exception);

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
    mockLivestreamService.addResponse(expectedResponse);

    String name = "name3373707";

    Clip actualResponse = client.getClip(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockLivestreamService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetClipRequest actualRequest = ((GetClipRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getClipExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockLivestreamService.addException(exception);

    try {
      String name = "name3373707";
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
    mockLivestreamService.addResponse(resultOperation);

    ChannelName parent = ChannelName.of("[PROJECT]", "[LOCATION]", "[CHANNEL]");
    Clip clip = Clip.newBuilder().build();
    String clipId = "clipId-1357703029";

    Clip actualResponse = client.createClipAsync(parent, clip, clipId).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockLivestreamService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateClipRequest actualRequest = ((CreateClipRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(clip, actualRequest.getClip());
    Assert.assertEquals(clipId, actualRequest.getClipId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createClipExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockLivestreamService.addException(exception);

    try {
      ChannelName parent = ChannelName.of("[PROJECT]", "[LOCATION]", "[CHANNEL]");
      Clip clip = Clip.newBuilder().build();
      String clipId = "clipId-1357703029";
      client.createClipAsync(parent, clip, clipId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
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
    mockLivestreamService.addResponse(resultOperation);

    String parent = "parent-995424086";
    Clip clip = Clip.newBuilder().build();
    String clipId = "clipId-1357703029";

    Clip actualResponse = client.createClipAsync(parent, clip, clipId).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockLivestreamService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateClipRequest actualRequest = ((CreateClipRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(clip, actualRequest.getClip());
    Assert.assertEquals(clipId, actualRequest.getClipId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createClipExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockLivestreamService.addException(exception);

    try {
      String parent = "parent-995424086";
      Clip clip = Clip.newBuilder().build();
      String clipId = "clipId-1357703029";
      client.createClipAsync(parent, clip, clipId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
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
    mockLivestreamService.addResponse(resultOperation);

    ClipName name = ClipName.of("[PROJECT]", "[LOCATION]", "[CHANNEL]", "[CLIP]");

    client.deleteClipAsync(name).get();

    List<AbstractMessage> actualRequests = mockLivestreamService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteClipRequest actualRequest = ((DeleteClipRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteClipExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockLivestreamService.addException(exception);

    try {
      ClipName name = ClipName.of("[PROJECT]", "[LOCATION]", "[CHANNEL]", "[CLIP]");
      client.deleteClipAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
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
    mockLivestreamService.addResponse(resultOperation);

    String name = "name3373707";

    client.deleteClipAsync(name).get();

    List<AbstractMessage> actualRequests = mockLivestreamService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteClipRequest actualRequest = ((DeleteClipRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteClipExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockLivestreamService.addException(exception);

    try {
      String name = "name3373707";
      client.deleteClipAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
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
    mockLivestreamService.addResponse(resultOperation);

    ChannelName parent = ChannelName.of("[PROJECT]", "[LOCATION]", "[CHANNEL]");
    DvrSession dvrSession = DvrSession.newBuilder().build();
    String dvrSessionId = "dvrSessionId120568849";

    DvrSession actualResponse =
        client.createDvrSessionAsync(parent, dvrSession, dvrSessionId).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockLivestreamService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateDvrSessionRequest actualRequest = ((CreateDvrSessionRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(dvrSession, actualRequest.getDvrSession());
    Assert.assertEquals(dvrSessionId, actualRequest.getDvrSessionId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createDvrSessionExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockLivestreamService.addException(exception);

    try {
      ChannelName parent = ChannelName.of("[PROJECT]", "[LOCATION]", "[CHANNEL]");
      DvrSession dvrSession = DvrSession.newBuilder().build();
      String dvrSessionId = "dvrSessionId120568849";
      client.createDvrSessionAsync(parent, dvrSession, dvrSessionId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
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
    mockLivestreamService.addResponse(resultOperation);

    String parent = "parent-995424086";
    DvrSession dvrSession = DvrSession.newBuilder().build();
    String dvrSessionId = "dvrSessionId120568849";

    DvrSession actualResponse =
        client.createDvrSessionAsync(parent, dvrSession, dvrSessionId).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockLivestreamService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateDvrSessionRequest actualRequest = ((CreateDvrSessionRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(dvrSession, actualRequest.getDvrSession());
    Assert.assertEquals(dvrSessionId, actualRequest.getDvrSessionId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createDvrSessionExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockLivestreamService.addException(exception);

    try {
      String parent = "parent-995424086";
      DvrSession dvrSession = DvrSession.newBuilder().build();
      String dvrSessionId = "dvrSessionId120568849";
      client.createDvrSessionAsync(parent, dvrSession, dvrSessionId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
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
    mockLivestreamService.addResponse(expectedResponse);

    ChannelName parent = ChannelName.of("[PROJECT]", "[LOCATION]", "[CHANNEL]");

    ListDvrSessionsPagedResponse pagedListResponse = client.listDvrSessions(parent);

    List<DvrSession> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getDvrSessionsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockLivestreamService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListDvrSessionsRequest actualRequest = ((ListDvrSessionsRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listDvrSessionsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockLivestreamService.addException(exception);

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
    mockLivestreamService.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListDvrSessionsPagedResponse pagedListResponse = client.listDvrSessions(parent);

    List<DvrSession> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getDvrSessionsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockLivestreamService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListDvrSessionsRequest actualRequest = ((ListDvrSessionsRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listDvrSessionsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockLivestreamService.addException(exception);

    try {
      String parent = "parent-995424086";
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
    mockLivestreamService.addResponse(expectedResponse);

    DvrSessionName name =
        DvrSessionName.of("[PROJECT]", "[LOCATION]", "[CHANNEL]", "[DVR_SESSION]");

    DvrSession actualResponse = client.getDvrSession(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockLivestreamService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetDvrSessionRequest actualRequest = ((GetDvrSessionRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getDvrSessionExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockLivestreamService.addException(exception);

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
    mockLivestreamService.addResponse(expectedResponse);

    String name = "name3373707";

    DvrSession actualResponse = client.getDvrSession(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockLivestreamService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetDvrSessionRequest actualRequest = ((GetDvrSessionRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getDvrSessionExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockLivestreamService.addException(exception);

    try {
      String name = "name3373707";
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
    mockLivestreamService.addResponse(resultOperation);

    DvrSessionName name =
        DvrSessionName.of("[PROJECT]", "[LOCATION]", "[CHANNEL]", "[DVR_SESSION]");

    client.deleteDvrSessionAsync(name).get();

    List<AbstractMessage> actualRequests = mockLivestreamService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteDvrSessionRequest actualRequest = ((DeleteDvrSessionRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteDvrSessionExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockLivestreamService.addException(exception);

    try {
      DvrSessionName name =
          DvrSessionName.of("[PROJECT]", "[LOCATION]", "[CHANNEL]", "[DVR_SESSION]");
      client.deleteDvrSessionAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
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
    mockLivestreamService.addResponse(resultOperation);

    String name = "name3373707";

    client.deleteDvrSessionAsync(name).get();

    List<AbstractMessage> actualRequests = mockLivestreamService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteDvrSessionRequest actualRequest = ((DeleteDvrSessionRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteDvrSessionExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockLivestreamService.addException(exception);

    try {
      String name = "name3373707";
      client.deleteDvrSessionAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
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
    mockLivestreamService.addResponse(resultOperation);

    DvrSession dvrSession = DvrSession.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    DvrSession actualResponse = client.updateDvrSessionAsync(dvrSession, updateMask).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockLivestreamService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateDvrSessionRequest actualRequest = ((UpdateDvrSessionRequest) actualRequests.get(0));

    Assert.assertEquals(dvrSession, actualRequest.getDvrSession());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateDvrSessionExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockLivestreamService.addException(exception);

    try {
      DvrSession dvrSession = DvrSession.newBuilder().build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateDvrSessionAsync(dvrSession, updateMask).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
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
    mockLivestreamService.addResponse(resultOperation);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
    Asset asset = Asset.newBuilder().build();
    String assetId = "assetId-704776149";

    Asset actualResponse = client.createAssetAsync(parent, asset, assetId).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockLivestreamService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateAssetRequest actualRequest = ((CreateAssetRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(asset, actualRequest.getAsset());
    Assert.assertEquals(assetId, actualRequest.getAssetId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createAssetExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockLivestreamService.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      Asset asset = Asset.newBuilder().build();
      String assetId = "assetId-704776149";
      client.createAssetAsync(parent, asset, assetId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
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
    mockLivestreamService.addResponse(resultOperation);

    String parent = "parent-995424086";
    Asset asset = Asset.newBuilder().build();
    String assetId = "assetId-704776149";

    Asset actualResponse = client.createAssetAsync(parent, asset, assetId).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockLivestreamService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateAssetRequest actualRequest = ((CreateAssetRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(asset, actualRequest.getAsset());
    Assert.assertEquals(assetId, actualRequest.getAssetId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createAssetExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockLivestreamService.addException(exception);

    try {
      String parent = "parent-995424086";
      Asset asset = Asset.newBuilder().build();
      String assetId = "assetId-704776149";
      client.createAssetAsync(parent, asset, assetId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
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
    mockLivestreamService.addResponse(resultOperation);

    AssetName name = AssetName.of("[PROJECT]", "[LOCATION]", "[ASSET]");

    client.deleteAssetAsync(name).get();

    List<AbstractMessage> actualRequests = mockLivestreamService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteAssetRequest actualRequest = ((DeleteAssetRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteAssetExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockLivestreamService.addException(exception);

    try {
      AssetName name = AssetName.of("[PROJECT]", "[LOCATION]", "[ASSET]");
      client.deleteAssetAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
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
    mockLivestreamService.addResponse(resultOperation);

    String name = "name3373707";

    client.deleteAssetAsync(name).get();

    List<AbstractMessage> actualRequests = mockLivestreamService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteAssetRequest actualRequest = ((DeleteAssetRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteAssetExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockLivestreamService.addException(exception);

    try {
      String name = "name3373707";
      client.deleteAssetAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
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
    mockLivestreamService.addResponse(expectedResponse);

    AssetName name = AssetName.of("[PROJECT]", "[LOCATION]", "[ASSET]");

    Asset actualResponse = client.getAsset(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockLivestreamService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetAssetRequest actualRequest = ((GetAssetRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getAssetExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockLivestreamService.addException(exception);

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
    mockLivestreamService.addResponse(expectedResponse);

    String name = "name3373707";

    Asset actualResponse = client.getAsset(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockLivestreamService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetAssetRequest actualRequest = ((GetAssetRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getAssetExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockLivestreamService.addException(exception);

    try {
      String name = "name3373707";
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
    mockLivestreamService.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

    ListAssetsPagedResponse pagedListResponse = client.listAssets(parent);

    List<Asset> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getAssetsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockLivestreamService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListAssetsRequest actualRequest = ((ListAssetsRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listAssetsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockLivestreamService.addException(exception);

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
    mockLivestreamService.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListAssetsPagedResponse pagedListResponse = client.listAssets(parent);

    List<Asset> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getAssetsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockLivestreamService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListAssetsRequest actualRequest = ((ListAssetsRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listAssetsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockLivestreamService.addException(exception);

    try {
      String parent = "parent-995424086";
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
    mockLivestreamService.addResponse(expectedResponse);

    PoolName name = PoolName.of("[PROJECT]", "[LOCATION]", "[POOL]");

    Pool actualResponse = client.getPool(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockLivestreamService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetPoolRequest actualRequest = ((GetPoolRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getPoolExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockLivestreamService.addException(exception);

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
    mockLivestreamService.addResponse(expectedResponse);

    String name = "name3373707";

    Pool actualResponse = client.getPool(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockLivestreamService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetPoolRequest actualRequest = ((GetPoolRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getPoolExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockLivestreamService.addException(exception);

    try {
      String name = "name3373707";
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
    mockLivestreamService.addResponse(resultOperation);

    Pool pool = Pool.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    Pool actualResponse = client.updatePoolAsync(pool, updateMask).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockLivestreamService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdatePoolRequest actualRequest = ((UpdatePoolRequest) actualRequests.get(0));

    Assert.assertEquals(pool, actualRequest.getPool());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updatePoolExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockLivestreamService.addException(exception);

    try {
      Pool pool = Pool.newBuilder().build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updatePoolAsync(pool, updateMask).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
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
    mockLocations.addResponse(expectedResponse);

    ListLocationsRequest request =
        ListLocationsRequest.newBuilder()
            .setName("name3373707")
            .setFilter("filter-1274492040")
            .setPageSize(883849137)
            .setPageToken("pageToken873572522")
            .build();

    ListLocationsPagedResponse pagedListResponse = client.listLocations(request);

    List<Location> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getLocationsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockLocations.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListLocationsRequest actualRequest = ((ListLocationsRequest) actualRequests.get(0));

    Assert.assertEquals(request.getName(), actualRequest.getName());
    Assert.assertEquals(request.getFilter(), actualRequest.getFilter());
    Assert.assertEquals(request.getPageSize(), actualRequest.getPageSize());
    Assert.assertEquals(request.getPageToken(), actualRequest.getPageToken());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listLocationsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockLocations.addException(exception);

    try {
      ListLocationsRequest request =
          ListLocationsRequest.newBuilder()
              .setName("name3373707")
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
    mockLocations.addResponse(expectedResponse);

    GetLocationRequest request = GetLocationRequest.newBuilder().setName("name3373707").build();

    Location actualResponse = client.getLocation(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockLocations.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetLocationRequest actualRequest = ((GetLocationRequest) actualRequests.get(0));

    Assert.assertEquals(request.getName(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getLocationExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockLocations.addException(exception);

    try {
      GetLocationRequest request = GetLocationRequest.newBuilder().setName("name3373707").build();
      client.getLocation(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
