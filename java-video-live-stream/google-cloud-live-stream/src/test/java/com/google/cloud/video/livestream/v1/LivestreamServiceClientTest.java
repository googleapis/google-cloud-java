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

package com.google.cloud.video.livestream.v1;

import static com.google.cloud.video.livestream.v1.LivestreamServiceClient.ListChannelsPagedResponse;
import static com.google.cloud.video.livestream.v1.LivestreamServiceClient.ListEventsPagedResponse;
import static com.google.cloud.video.livestream.v1.LivestreamServiceClient.ListInputsPagedResponse;

import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.grpc.GaxGrpcProperties;
import com.google.api.gax.grpc.testing.LocalChannelProvider;
import com.google.api.gax.grpc.testing.MockGrpcService;
import com.google.api.gax.grpc.testing.MockServiceHelper;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.api.gax.rpc.StatusCode;
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
  private static MockServiceHelper mockServiceHelper;
  private LocalChannelProvider channelProvider;
  private LivestreamServiceClient client;

  @BeforeClass
  public static void startStaticServer() {
    mockLivestreamService = new MockLivestreamService();
    mockServiceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(), Arrays.<MockGrpcService>asList(mockLivestreamService));
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
            .addAllSpriteSheets(new ArrayList<SpriteSheet>())
            .setStreamingError(Status.newBuilder().build())
            .setLogConfig(LogConfig.newBuilder().build())
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
            .addAllSpriteSheets(new ArrayList<SpriteSheet>())
            .setStreamingError(Status.newBuilder().build())
            .setLogConfig(LogConfig.newBuilder().build())
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
            .addAllSpriteSheets(new ArrayList<SpriteSheet>())
            .setStreamingError(Status.newBuilder().build())
            .setLogConfig(LogConfig.newBuilder().build())
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
            .addAllSpriteSheets(new ArrayList<SpriteSheet>())
            .setStreamingError(Status.newBuilder().build())
            .setLogConfig(LogConfig.newBuilder().build())
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
            .addAllSpriteSheets(new ArrayList<SpriteSheet>())
            .setStreamingError(Status.newBuilder().build())
            .setLogConfig(LogConfig.newBuilder().build())
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
}
