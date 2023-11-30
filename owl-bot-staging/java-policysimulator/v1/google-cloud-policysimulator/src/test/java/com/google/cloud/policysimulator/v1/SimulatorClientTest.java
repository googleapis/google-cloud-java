/*
 * Copyright 2023 Google LLC
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

package com.google.cloud.policysimulator.v1;

import static com.google.cloud.policysimulator.v1.SimulatorClient.ListReplayResultsPagedResponse;

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
import io.grpc.StatusRuntimeException;
import java.io.IOException;
import java.util.Arrays;
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
public class SimulatorClientTest {
  private static MockServiceHelper mockServiceHelper;
  private static MockSimulator mockSimulator;
  private LocalChannelProvider channelProvider;
  private SimulatorClient client;

  @BeforeClass
  public static void startStaticServer() {
    mockSimulator = new MockSimulator();
    mockServiceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(), Arrays.<MockGrpcService>asList(mockSimulator));
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
    SimulatorSettings settings =
        SimulatorSettings.newBuilder()
            .setTransportChannelProvider(channelProvider)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = SimulatorClient.create(settings);
  }

  @After
  public void tearDown() throws Exception {
    client.close();
  }

  @Test
  public void getReplayTest() throws Exception {
    Replay expectedResponse =
        Replay.newBuilder()
            .setName(
                ReplayName.ofProjectLocationReplayName("[PROJECT]", "[LOCATION]", "[REPLAY]")
                    .toString())
            .setConfig(ReplayConfig.newBuilder().build())
            .setResultsSummary(Replay.ResultsSummary.newBuilder().build())
            .build();
    mockSimulator.addResponse(expectedResponse);

    ReplayName name = ReplayName.ofProjectLocationReplayName("[PROJECT]", "[LOCATION]", "[REPLAY]");

    Replay actualResponse = client.getReplay(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockSimulator.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetReplayRequest actualRequest = ((GetReplayRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getReplayExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSimulator.addException(exception);

    try {
      ReplayName name =
          ReplayName.ofProjectLocationReplayName("[PROJECT]", "[LOCATION]", "[REPLAY]");
      client.getReplay(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getReplayTest2() throws Exception {
    Replay expectedResponse =
        Replay.newBuilder()
            .setName(
                ReplayName.ofProjectLocationReplayName("[PROJECT]", "[LOCATION]", "[REPLAY]")
                    .toString())
            .setConfig(ReplayConfig.newBuilder().build())
            .setResultsSummary(Replay.ResultsSummary.newBuilder().build())
            .build();
    mockSimulator.addResponse(expectedResponse);

    String name = "name3373707";

    Replay actualResponse = client.getReplay(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockSimulator.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetReplayRequest actualRequest = ((GetReplayRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getReplayExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSimulator.addException(exception);

    try {
      String name = "name3373707";
      client.getReplay(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createReplayTest() throws Exception {
    Replay expectedResponse =
        Replay.newBuilder()
            .setName(
                ReplayName.ofProjectLocationReplayName("[PROJECT]", "[LOCATION]", "[REPLAY]")
                    .toString())
            .setConfig(ReplayConfig.newBuilder().build())
            .setResultsSummary(Replay.ResultsSummary.newBuilder().build())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createReplayTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockSimulator.addResponse(resultOperation);

    String parent = "parent-995424086";
    Replay replay = Replay.newBuilder().build();

    Replay actualResponse = client.createReplayAsync(parent, replay).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockSimulator.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateReplayRequest actualRequest = ((CreateReplayRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(replay, actualRequest.getReplay());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createReplayExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSimulator.addException(exception);

    try {
      String parent = "parent-995424086";
      Replay replay = Replay.newBuilder().build();
      client.createReplayAsync(parent, replay).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void listReplayResultsTest() throws Exception {
    ReplayResult responsesElement = ReplayResult.newBuilder().build();
    ListReplayResultsResponse expectedResponse =
        ListReplayResultsResponse.newBuilder()
            .setNextPageToken("")
            .addAllReplayResults(Arrays.asList(responsesElement))
            .build();
    mockSimulator.addResponse(expectedResponse);

    ReplayName parent =
        ReplayName.ofProjectLocationReplayName("[PROJECT]", "[LOCATION]", "[REPLAY]");

    ListReplayResultsPagedResponse pagedListResponse = client.listReplayResults(parent);

    List<ReplayResult> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getReplayResultsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockSimulator.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListReplayResultsRequest actualRequest = ((ListReplayResultsRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listReplayResultsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSimulator.addException(exception);

    try {
      ReplayName parent =
          ReplayName.ofProjectLocationReplayName("[PROJECT]", "[LOCATION]", "[REPLAY]");
      client.listReplayResults(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listReplayResultsTest2() throws Exception {
    ReplayResult responsesElement = ReplayResult.newBuilder().build();
    ListReplayResultsResponse expectedResponse =
        ListReplayResultsResponse.newBuilder()
            .setNextPageToken("")
            .addAllReplayResults(Arrays.asList(responsesElement))
            .build();
    mockSimulator.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListReplayResultsPagedResponse pagedListResponse = client.listReplayResults(parent);

    List<ReplayResult> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getReplayResultsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockSimulator.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListReplayResultsRequest actualRequest = ((ListReplayResultsRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listReplayResultsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSimulator.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listReplayResults(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
