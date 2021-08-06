/*
 * Copyright 2021 Google LLC
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

package com.google.cloud.eventarc.v1;

import static com.google.cloud.eventarc.v1.EventarcClient.ListTriggersPagedResponse;

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
import com.google.protobuf.FieldMask;
import com.google.protobuf.Timestamp;
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
public class EventarcClientTest {
  private static MockEventarc mockEventarc;
  private static MockServiceHelper mockServiceHelper;
  private LocalChannelProvider channelProvider;
  private EventarcClient client;

  @BeforeClass
  public static void startStaticServer() {
    mockEventarc = new MockEventarc();
    mockServiceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(), Arrays.<MockGrpcService>asList(mockEventarc));
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
    EventarcSettings settings =
        EventarcSettings.newBuilder()
            .setTransportChannelProvider(channelProvider)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = EventarcClient.create(settings);
  }

  @After
  public void tearDown() throws Exception {
    client.close();
  }

  @Test
  public void getTriggerTest() throws Exception {
    Trigger expectedResponse =
        Trigger.newBuilder()
            .setName(TriggerName.of("[PROJECT]", "[LOCATION]", "[TRIGGER]").toString())
            .setUid("uid115792")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .addAllEventFilters(new ArrayList<EventFilter>())
            .setServiceAccount("serviceAccount1079137720")
            .setDestination(Destination.newBuilder().build())
            .setTransport(Transport.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setEtag("etag3123477")
            .build();
    mockEventarc.addResponse(expectedResponse);

    TriggerName name = TriggerName.of("[PROJECT]", "[LOCATION]", "[TRIGGER]");

    Trigger actualResponse = client.getTrigger(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockEventarc.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetTriggerRequest actualRequest = ((GetTriggerRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getTriggerExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockEventarc.addException(exception);

    try {
      TriggerName name = TriggerName.of("[PROJECT]", "[LOCATION]", "[TRIGGER]");
      client.getTrigger(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getTriggerTest2() throws Exception {
    Trigger expectedResponse =
        Trigger.newBuilder()
            .setName(TriggerName.of("[PROJECT]", "[LOCATION]", "[TRIGGER]").toString())
            .setUid("uid115792")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .addAllEventFilters(new ArrayList<EventFilter>())
            .setServiceAccount("serviceAccount1079137720")
            .setDestination(Destination.newBuilder().build())
            .setTransport(Transport.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setEtag("etag3123477")
            .build();
    mockEventarc.addResponse(expectedResponse);

    String name = "name3373707";

    Trigger actualResponse = client.getTrigger(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockEventarc.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetTriggerRequest actualRequest = ((GetTriggerRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getTriggerExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockEventarc.addException(exception);

    try {
      String name = "name3373707";
      client.getTrigger(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listTriggersTest() throws Exception {
    Trigger responsesElement = Trigger.newBuilder().build();
    ListTriggersResponse expectedResponse =
        ListTriggersResponse.newBuilder()
            .setNextPageToken("")
            .addAllTriggers(Arrays.asList(responsesElement))
            .build();
    mockEventarc.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

    ListTriggersPagedResponse pagedListResponse = client.listTriggers(parent);

    List<Trigger> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getTriggersList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockEventarc.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListTriggersRequest actualRequest = ((ListTriggersRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listTriggersExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockEventarc.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      client.listTriggers(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listTriggersTest2() throws Exception {
    Trigger responsesElement = Trigger.newBuilder().build();
    ListTriggersResponse expectedResponse =
        ListTriggersResponse.newBuilder()
            .setNextPageToken("")
            .addAllTriggers(Arrays.asList(responsesElement))
            .build();
    mockEventarc.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListTriggersPagedResponse pagedListResponse = client.listTriggers(parent);

    List<Trigger> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getTriggersList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockEventarc.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListTriggersRequest actualRequest = ((ListTriggersRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listTriggersExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockEventarc.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listTriggers(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createTriggerTest() throws Exception {
    Trigger expectedResponse =
        Trigger.newBuilder()
            .setName(TriggerName.of("[PROJECT]", "[LOCATION]", "[TRIGGER]").toString())
            .setUid("uid115792")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .addAllEventFilters(new ArrayList<EventFilter>())
            .setServiceAccount("serviceAccount1079137720")
            .setDestination(Destination.newBuilder().build())
            .setTransport(Transport.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setEtag("etag3123477")
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createTriggerTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockEventarc.addResponse(resultOperation);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
    Trigger trigger = Trigger.newBuilder().build();
    String triggerId = "triggerId-648752909";

    Trigger actualResponse = client.createTriggerAsync(parent, trigger, triggerId).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockEventarc.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateTriggerRequest actualRequest = ((CreateTriggerRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(trigger, actualRequest.getTrigger());
    Assert.assertEquals(triggerId, actualRequest.getTriggerId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createTriggerExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockEventarc.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      Trigger trigger = Trigger.newBuilder().build();
      String triggerId = "triggerId-648752909";
      client.createTriggerAsync(parent, trigger, triggerId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void createTriggerTest2() throws Exception {
    Trigger expectedResponse =
        Trigger.newBuilder()
            .setName(TriggerName.of("[PROJECT]", "[LOCATION]", "[TRIGGER]").toString())
            .setUid("uid115792")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .addAllEventFilters(new ArrayList<EventFilter>())
            .setServiceAccount("serviceAccount1079137720")
            .setDestination(Destination.newBuilder().build())
            .setTransport(Transport.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setEtag("etag3123477")
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createTriggerTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockEventarc.addResponse(resultOperation);

    String parent = "parent-995424086";
    Trigger trigger = Trigger.newBuilder().build();
    String triggerId = "triggerId-648752909";

    Trigger actualResponse = client.createTriggerAsync(parent, trigger, triggerId).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockEventarc.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateTriggerRequest actualRequest = ((CreateTriggerRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(trigger, actualRequest.getTrigger());
    Assert.assertEquals(triggerId, actualRequest.getTriggerId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createTriggerExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockEventarc.addException(exception);

    try {
      String parent = "parent-995424086";
      Trigger trigger = Trigger.newBuilder().build();
      String triggerId = "triggerId-648752909";
      client.createTriggerAsync(parent, trigger, triggerId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void updateTriggerTest() throws Exception {
    Trigger expectedResponse =
        Trigger.newBuilder()
            .setName(TriggerName.of("[PROJECT]", "[LOCATION]", "[TRIGGER]").toString())
            .setUid("uid115792")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .addAllEventFilters(new ArrayList<EventFilter>())
            .setServiceAccount("serviceAccount1079137720")
            .setDestination(Destination.newBuilder().build())
            .setTransport(Transport.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setEtag("etag3123477")
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("updateTriggerTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockEventarc.addResponse(resultOperation);

    Trigger trigger = Trigger.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();
    boolean allowMissing = true;

    Trigger actualResponse = client.updateTriggerAsync(trigger, updateMask, allowMissing).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockEventarc.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateTriggerRequest actualRequest = ((UpdateTriggerRequest) actualRequests.get(0));

    Assert.assertEquals(trigger, actualRequest.getTrigger());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertEquals(allowMissing, actualRequest.getAllowMissing());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateTriggerExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockEventarc.addException(exception);

    try {
      Trigger trigger = Trigger.newBuilder().build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      boolean allowMissing = true;
      client.updateTriggerAsync(trigger, updateMask, allowMissing).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void deleteTriggerTest() throws Exception {
    Trigger expectedResponse =
        Trigger.newBuilder()
            .setName(TriggerName.of("[PROJECT]", "[LOCATION]", "[TRIGGER]").toString())
            .setUid("uid115792")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .addAllEventFilters(new ArrayList<EventFilter>())
            .setServiceAccount("serviceAccount1079137720")
            .setDestination(Destination.newBuilder().build())
            .setTransport(Transport.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setEtag("etag3123477")
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteTriggerTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockEventarc.addResponse(resultOperation);

    TriggerName name = TriggerName.of("[PROJECT]", "[LOCATION]", "[TRIGGER]");
    boolean allowMissing = true;

    Trigger actualResponse = client.deleteTriggerAsync(name, allowMissing).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockEventarc.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteTriggerRequest actualRequest = ((DeleteTriggerRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertEquals(allowMissing, actualRequest.getAllowMissing());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteTriggerExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockEventarc.addException(exception);

    try {
      TriggerName name = TriggerName.of("[PROJECT]", "[LOCATION]", "[TRIGGER]");
      boolean allowMissing = true;
      client.deleteTriggerAsync(name, allowMissing).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void deleteTriggerTest2() throws Exception {
    Trigger expectedResponse =
        Trigger.newBuilder()
            .setName(TriggerName.of("[PROJECT]", "[LOCATION]", "[TRIGGER]").toString())
            .setUid("uid115792")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .addAllEventFilters(new ArrayList<EventFilter>())
            .setServiceAccount("serviceAccount1079137720")
            .setDestination(Destination.newBuilder().build())
            .setTransport(Transport.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setEtag("etag3123477")
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteTriggerTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockEventarc.addResponse(resultOperation);

    String name = "name3373707";
    boolean allowMissing = true;

    Trigger actualResponse = client.deleteTriggerAsync(name, allowMissing).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockEventarc.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteTriggerRequest actualRequest = ((DeleteTriggerRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertEquals(allowMissing, actualRequest.getAllowMissing());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteTriggerExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockEventarc.addException(exception);

    try {
      String name = "name3373707";
      boolean allowMissing = true;
      client.deleteTriggerAsync(name, allowMissing).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }
}
