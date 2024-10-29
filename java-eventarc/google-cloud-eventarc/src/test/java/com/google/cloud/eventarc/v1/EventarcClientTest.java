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

package com.google.cloud.eventarc.v1;

import static com.google.cloud.eventarc.v1.EventarcClient.ListChannelConnectionsPagedResponse;
import static com.google.cloud.eventarc.v1.EventarcClient.ListChannelsPagedResponse;
import static com.google.cloud.eventarc.v1.EventarcClient.ListEnrollmentsPagedResponse;
import static com.google.cloud.eventarc.v1.EventarcClient.ListGoogleApiSourcesPagedResponse;
import static com.google.cloud.eventarc.v1.EventarcClient.ListLocationsPagedResponse;
import static com.google.cloud.eventarc.v1.EventarcClient.ListMessageBusEnrollmentsPagedResponse;
import static com.google.cloud.eventarc.v1.EventarcClient.ListMessageBusesPagedResponse;
import static com.google.cloud.eventarc.v1.EventarcClient.ListPipelinesPagedResponse;
import static com.google.cloud.eventarc.v1.EventarcClient.ListProvidersPagedResponse;
import static com.google.cloud.eventarc.v1.EventarcClient.ListTriggersPagedResponse;

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
import com.google.iam.v1.AuditConfig;
import com.google.iam.v1.Binding;
import com.google.iam.v1.GetIamPolicyRequest;
import com.google.iam.v1.GetPolicyOptions;
import com.google.iam.v1.Policy;
import com.google.iam.v1.SetIamPolicyRequest;
import com.google.iam.v1.TestIamPermissionsRequest;
import com.google.iam.v1.TestIamPermissionsResponse;
import com.google.longrunning.Operation;
import com.google.protobuf.AbstractMessage;
import com.google.protobuf.Any;
import com.google.protobuf.ByteString;
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
  private static MockIAMPolicy mockIAMPolicy;
  private static MockLocations mockLocations;
  private static MockServiceHelper mockServiceHelper;
  private LocalChannelProvider channelProvider;
  private EventarcClient client;

  @BeforeClass
  public static void startStaticServer() {
    mockEventarc = new MockEventarc();
    mockLocations = new MockLocations();
    mockIAMPolicy = new MockIAMPolicy();
    mockServiceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(),
            Arrays.<MockGrpcService>asList(mockEventarc, mockLocations, mockIAMPolicy));
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
            .setChannel("channel738950403")
            .putAllConditions(new HashMap<String, StateCondition>())
            .setEventDataContentType("eventDataContentType1497299791")
            .setSatisfiesPzs(true)
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
            .setChannel("channel738950403")
            .putAllConditions(new HashMap<String, StateCondition>())
            .setEventDataContentType("eventDataContentType1497299791")
            .setSatisfiesPzs(true)
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
            .setChannel("channel738950403")
            .putAllConditions(new HashMap<String, StateCondition>())
            .setEventDataContentType("eventDataContentType1497299791")
            .setSatisfiesPzs(true)
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
            .setChannel("channel738950403")
            .putAllConditions(new HashMap<String, StateCondition>())
            .setEventDataContentType("eventDataContentType1497299791")
            .setSatisfiesPzs(true)
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
            .setChannel("channel738950403")
            .putAllConditions(new HashMap<String, StateCondition>())
            .setEventDataContentType("eventDataContentType1497299791")
            .setSatisfiesPzs(true)
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
            .setChannel("channel738950403")
            .putAllConditions(new HashMap<String, StateCondition>())
            .setEventDataContentType("eventDataContentType1497299791")
            .setSatisfiesPzs(true)
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
            .setChannel("channel738950403")
            .putAllConditions(new HashMap<String, StateCondition>())
            .setEventDataContentType("eventDataContentType1497299791")
            .setSatisfiesPzs(true)
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

  @Test
  public void getChannelTest() throws Exception {
    Channel expectedResponse =
        Channel.newBuilder()
            .setName(ChannelName.of("[PROJECT]", "[LOCATION]", "[CHANNEL]").toString())
            .setUid("uid115792")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setProvider("provider-987494927")
            .setActivationToken("activationToken1276937859")
            .setCryptoKeyName("cryptoKeyName1447084425")
            .setSatisfiesPzs(true)
            .build();
    mockEventarc.addResponse(expectedResponse);

    ChannelName name = ChannelName.of("[PROJECT]", "[LOCATION]", "[CHANNEL]");

    Channel actualResponse = client.getChannel(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockEventarc.getRequests();
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
    mockEventarc.addException(exception);

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
            .setUid("uid115792")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setProvider("provider-987494927")
            .setActivationToken("activationToken1276937859")
            .setCryptoKeyName("cryptoKeyName1447084425")
            .setSatisfiesPzs(true)
            .build();
    mockEventarc.addResponse(expectedResponse);

    String name = "name3373707";

    Channel actualResponse = client.getChannel(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockEventarc.getRequests();
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
    mockEventarc.addException(exception);

    try {
      String name = "name3373707";
      client.getChannel(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
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
    mockEventarc.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

    ListChannelsPagedResponse pagedListResponse = client.listChannels(parent);

    List<Channel> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getChannelsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockEventarc.getRequests();
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
    mockEventarc.addException(exception);

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
    mockEventarc.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListChannelsPagedResponse pagedListResponse = client.listChannels(parent);

    List<Channel> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getChannelsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockEventarc.getRequests();
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
    mockEventarc.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listChannels(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createChannelTest() throws Exception {
    Channel expectedResponse =
        Channel.newBuilder()
            .setName(ChannelName.of("[PROJECT]", "[LOCATION]", "[CHANNEL]").toString())
            .setUid("uid115792")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setProvider("provider-987494927")
            .setActivationToken("activationToken1276937859")
            .setCryptoKeyName("cryptoKeyName1447084425")
            .setSatisfiesPzs(true)
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createChannelTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockEventarc.addResponse(resultOperation);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
    Channel channel = Channel.newBuilder().build();
    String channelId = "channelId1461735806";

    Channel actualResponse = client.createChannelAsync(parent, channel, channelId).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockEventarc.getRequests();
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
    mockEventarc.addException(exception);

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
            .setUid("uid115792")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setProvider("provider-987494927")
            .setActivationToken("activationToken1276937859")
            .setCryptoKeyName("cryptoKeyName1447084425")
            .setSatisfiesPzs(true)
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createChannelTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockEventarc.addResponse(resultOperation);

    String parent = "parent-995424086";
    Channel channel = Channel.newBuilder().build();
    String channelId = "channelId1461735806";

    Channel actualResponse = client.createChannelAsync(parent, channel, channelId).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockEventarc.getRequests();
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
    mockEventarc.addException(exception);

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
  public void updateChannelTest() throws Exception {
    Channel expectedResponse =
        Channel.newBuilder()
            .setName(ChannelName.of("[PROJECT]", "[LOCATION]", "[CHANNEL]").toString())
            .setUid("uid115792")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setProvider("provider-987494927")
            .setActivationToken("activationToken1276937859")
            .setCryptoKeyName("cryptoKeyName1447084425")
            .setSatisfiesPzs(true)
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("updateChannelTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockEventarc.addResponse(resultOperation);

    Channel channel = Channel.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    Channel actualResponse = client.updateChannelAsync(channel, updateMask).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockEventarc.getRequests();
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
    mockEventarc.addException(exception);

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
  public void deleteChannelTest() throws Exception {
    Channel expectedResponse =
        Channel.newBuilder()
            .setName(ChannelName.of("[PROJECT]", "[LOCATION]", "[CHANNEL]").toString())
            .setUid("uid115792")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setProvider("provider-987494927")
            .setActivationToken("activationToken1276937859")
            .setCryptoKeyName("cryptoKeyName1447084425")
            .setSatisfiesPzs(true)
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteChannelTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockEventarc.addResponse(resultOperation);

    ChannelName name = ChannelName.of("[PROJECT]", "[LOCATION]", "[CHANNEL]");

    Channel actualResponse = client.deleteChannelAsync(name).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockEventarc.getRequests();
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
    mockEventarc.addException(exception);

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
    Channel expectedResponse =
        Channel.newBuilder()
            .setName(ChannelName.of("[PROJECT]", "[LOCATION]", "[CHANNEL]").toString())
            .setUid("uid115792")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setProvider("provider-987494927")
            .setActivationToken("activationToken1276937859")
            .setCryptoKeyName("cryptoKeyName1447084425")
            .setSatisfiesPzs(true)
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteChannelTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockEventarc.addResponse(resultOperation);

    String name = "name3373707";

    Channel actualResponse = client.deleteChannelAsync(name).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockEventarc.getRequests();
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
    mockEventarc.addException(exception);

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
  public void getProviderTest() throws Exception {
    Provider expectedResponse =
        Provider.newBuilder()
            .setName(ProviderName.of("[PROJECT]", "[LOCATION]", "[PROVIDER]").toString())
            .setDisplayName("displayName1714148973")
            .addAllEventTypes(new ArrayList<EventType>())
            .build();
    mockEventarc.addResponse(expectedResponse);

    ProviderName name = ProviderName.of("[PROJECT]", "[LOCATION]", "[PROVIDER]");

    Provider actualResponse = client.getProvider(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockEventarc.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetProviderRequest actualRequest = ((GetProviderRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getProviderExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockEventarc.addException(exception);

    try {
      ProviderName name = ProviderName.of("[PROJECT]", "[LOCATION]", "[PROVIDER]");
      client.getProvider(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getProviderTest2() throws Exception {
    Provider expectedResponse =
        Provider.newBuilder()
            .setName(ProviderName.of("[PROJECT]", "[LOCATION]", "[PROVIDER]").toString())
            .setDisplayName("displayName1714148973")
            .addAllEventTypes(new ArrayList<EventType>())
            .build();
    mockEventarc.addResponse(expectedResponse);

    String name = "name3373707";

    Provider actualResponse = client.getProvider(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockEventarc.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetProviderRequest actualRequest = ((GetProviderRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getProviderExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockEventarc.addException(exception);

    try {
      String name = "name3373707";
      client.getProvider(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listProvidersTest() throws Exception {
    Provider responsesElement = Provider.newBuilder().build();
    ListProvidersResponse expectedResponse =
        ListProvidersResponse.newBuilder()
            .setNextPageToken("")
            .addAllProviders(Arrays.asList(responsesElement))
            .build();
    mockEventarc.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

    ListProvidersPagedResponse pagedListResponse = client.listProviders(parent);

    List<Provider> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getProvidersList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockEventarc.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListProvidersRequest actualRequest = ((ListProvidersRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listProvidersExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockEventarc.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      client.listProviders(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listProvidersTest2() throws Exception {
    Provider responsesElement = Provider.newBuilder().build();
    ListProvidersResponse expectedResponse =
        ListProvidersResponse.newBuilder()
            .setNextPageToken("")
            .addAllProviders(Arrays.asList(responsesElement))
            .build();
    mockEventarc.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListProvidersPagedResponse pagedListResponse = client.listProviders(parent);

    List<Provider> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getProvidersList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockEventarc.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListProvidersRequest actualRequest = ((ListProvidersRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listProvidersExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockEventarc.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listProviders(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getChannelConnectionTest() throws Exception {
    ChannelConnection expectedResponse =
        ChannelConnection.newBuilder()
            .setName(
                ChannelConnectionName.of("[PROJECT]", "[LOCATION]", "[CHANNEL_CONNECTION]")
                    .toString())
            .setUid("uid115792")
            .setChannel(ChannelName.of("[PROJECT]", "[LOCATION]", "[CHANNEL]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setActivationToken("activationToken1276937859")
            .build();
    mockEventarc.addResponse(expectedResponse);

    ChannelConnectionName name =
        ChannelConnectionName.of("[PROJECT]", "[LOCATION]", "[CHANNEL_CONNECTION]");

    ChannelConnection actualResponse = client.getChannelConnection(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockEventarc.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetChannelConnectionRequest actualRequest =
        ((GetChannelConnectionRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getChannelConnectionExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockEventarc.addException(exception);

    try {
      ChannelConnectionName name =
          ChannelConnectionName.of("[PROJECT]", "[LOCATION]", "[CHANNEL_CONNECTION]");
      client.getChannelConnection(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getChannelConnectionTest2() throws Exception {
    ChannelConnection expectedResponse =
        ChannelConnection.newBuilder()
            .setName(
                ChannelConnectionName.of("[PROJECT]", "[LOCATION]", "[CHANNEL_CONNECTION]")
                    .toString())
            .setUid("uid115792")
            .setChannel(ChannelName.of("[PROJECT]", "[LOCATION]", "[CHANNEL]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setActivationToken("activationToken1276937859")
            .build();
    mockEventarc.addResponse(expectedResponse);

    String name = "name3373707";

    ChannelConnection actualResponse = client.getChannelConnection(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockEventarc.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetChannelConnectionRequest actualRequest =
        ((GetChannelConnectionRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getChannelConnectionExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockEventarc.addException(exception);

    try {
      String name = "name3373707";
      client.getChannelConnection(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listChannelConnectionsTest() throws Exception {
    ChannelConnection responsesElement = ChannelConnection.newBuilder().build();
    ListChannelConnectionsResponse expectedResponse =
        ListChannelConnectionsResponse.newBuilder()
            .setNextPageToken("")
            .addAllChannelConnections(Arrays.asList(responsesElement))
            .build();
    mockEventarc.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

    ListChannelConnectionsPagedResponse pagedListResponse = client.listChannelConnections(parent);

    List<ChannelConnection> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getChannelConnectionsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockEventarc.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListChannelConnectionsRequest actualRequest =
        ((ListChannelConnectionsRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listChannelConnectionsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockEventarc.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      client.listChannelConnections(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listChannelConnectionsTest2() throws Exception {
    ChannelConnection responsesElement = ChannelConnection.newBuilder().build();
    ListChannelConnectionsResponse expectedResponse =
        ListChannelConnectionsResponse.newBuilder()
            .setNextPageToken("")
            .addAllChannelConnections(Arrays.asList(responsesElement))
            .build();
    mockEventarc.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListChannelConnectionsPagedResponse pagedListResponse = client.listChannelConnections(parent);

    List<ChannelConnection> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getChannelConnectionsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockEventarc.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListChannelConnectionsRequest actualRequest =
        ((ListChannelConnectionsRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listChannelConnectionsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockEventarc.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listChannelConnections(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createChannelConnectionTest() throws Exception {
    ChannelConnection expectedResponse =
        ChannelConnection.newBuilder()
            .setName(
                ChannelConnectionName.of("[PROJECT]", "[LOCATION]", "[CHANNEL_CONNECTION]")
                    .toString())
            .setUid("uid115792")
            .setChannel(ChannelName.of("[PROJECT]", "[LOCATION]", "[CHANNEL]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setActivationToken("activationToken1276937859")
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createChannelConnectionTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockEventarc.addResponse(resultOperation);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
    ChannelConnection channelConnection = ChannelConnection.newBuilder().build();
    String channelConnectionId = "channelConnectionId-1246974660";

    ChannelConnection actualResponse =
        client.createChannelConnectionAsync(parent, channelConnection, channelConnectionId).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockEventarc.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateChannelConnectionRequest actualRequest =
        ((CreateChannelConnectionRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(channelConnection, actualRequest.getChannelConnection());
    Assert.assertEquals(channelConnectionId, actualRequest.getChannelConnectionId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createChannelConnectionExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockEventarc.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      ChannelConnection channelConnection = ChannelConnection.newBuilder().build();
      String channelConnectionId = "channelConnectionId-1246974660";
      client.createChannelConnectionAsync(parent, channelConnection, channelConnectionId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void createChannelConnectionTest2() throws Exception {
    ChannelConnection expectedResponse =
        ChannelConnection.newBuilder()
            .setName(
                ChannelConnectionName.of("[PROJECT]", "[LOCATION]", "[CHANNEL_CONNECTION]")
                    .toString())
            .setUid("uid115792")
            .setChannel(ChannelName.of("[PROJECT]", "[LOCATION]", "[CHANNEL]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setActivationToken("activationToken1276937859")
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createChannelConnectionTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockEventarc.addResponse(resultOperation);

    String parent = "parent-995424086";
    ChannelConnection channelConnection = ChannelConnection.newBuilder().build();
    String channelConnectionId = "channelConnectionId-1246974660";

    ChannelConnection actualResponse =
        client.createChannelConnectionAsync(parent, channelConnection, channelConnectionId).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockEventarc.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateChannelConnectionRequest actualRequest =
        ((CreateChannelConnectionRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(channelConnection, actualRequest.getChannelConnection());
    Assert.assertEquals(channelConnectionId, actualRequest.getChannelConnectionId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createChannelConnectionExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockEventarc.addException(exception);

    try {
      String parent = "parent-995424086";
      ChannelConnection channelConnection = ChannelConnection.newBuilder().build();
      String channelConnectionId = "channelConnectionId-1246974660";
      client.createChannelConnectionAsync(parent, channelConnection, channelConnectionId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void deleteChannelConnectionTest() throws Exception {
    ChannelConnection expectedResponse =
        ChannelConnection.newBuilder()
            .setName(
                ChannelConnectionName.of("[PROJECT]", "[LOCATION]", "[CHANNEL_CONNECTION]")
                    .toString())
            .setUid("uid115792")
            .setChannel(ChannelName.of("[PROJECT]", "[LOCATION]", "[CHANNEL]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setActivationToken("activationToken1276937859")
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteChannelConnectionTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockEventarc.addResponse(resultOperation);

    ChannelConnectionName name =
        ChannelConnectionName.of("[PROJECT]", "[LOCATION]", "[CHANNEL_CONNECTION]");

    ChannelConnection actualResponse = client.deleteChannelConnectionAsync(name).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockEventarc.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteChannelConnectionRequest actualRequest =
        ((DeleteChannelConnectionRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteChannelConnectionExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockEventarc.addException(exception);

    try {
      ChannelConnectionName name =
          ChannelConnectionName.of("[PROJECT]", "[LOCATION]", "[CHANNEL_CONNECTION]");
      client.deleteChannelConnectionAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void deleteChannelConnectionTest2() throws Exception {
    ChannelConnection expectedResponse =
        ChannelConnection.newBuilder()
            .setName(
                ChannelConnectionName.of("[PROJECT]", "[LOCATION]", "[CHANNEL_CONNECTION]")
                    .toString())
            .setUid("uid115792")
            .setChannel(ChannelName.of("[PROJECT]", "[LOCATION]", "[CHANNEL]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setActivationToken("activationToken1276937859")
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteChannelConnectionTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockEventarc.addResponse(resultOperation);

    String name = "name3373707";

    ChannelConnection actualResponse = client.deleteChannelConnectionAsync(name).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockEventarc.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteChannelConnectionRequest actualRequest =
        ((DeleteChannelConnectionRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteChannelConnectionExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockEventarc.addException(exception);

    try {
      String name = "name3373707";
      client.deleteChannelConnectionAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void getGoogleChannelConfigTest() throws Exception {
    GoogleChannelConfig expectedResponse =
        GoogleChannelConfig.newBuilder()
            .setName(GoogleChannelConfigName.of("[PROJECT]", "[LOCATION]").toString())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setCryptoKeyName("cryptoKeyName1447084425")
            .build();
    mockEventarc.addResponse(expectedResponse);

    GoogleChannelConfigName name = GoogleChannelConfigName.of("[PROJECT]", "[LOCATION]");

    GoogleChannelConfig actualResponse = client.getGoogleChannelConfig(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockEventarc.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetGoogleChannelConfigRequest actualRequest =
        ((GetGoogleChannelConfigRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getGoogleChannelConfigExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockEventarc.addException(exception);

    try {
      GoogleChannelConfigName name = GoogleChannelConfigName.of("[PROJECT]", "[LOCATION]");
      client.getGoogleChannelConfig(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getGoogleChannelConfigTest2() throws Exception {
    GoogleChannelConfig expectedResponse =
        GoogleChannelConfig.newBuilder()
            .setName(GoogleChannelConfigName.of("[PROJECT]", "[LOCATION]").toString())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setCryptoKeyName("cryptoKeyName1447084425")
            .build();
    mockEventarc.addResponse(expectedResponse);

    String name = "name3373707";

    GoogleChannelConfig actualResponse = client.getGoogleChannelConfig(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockEventarc.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetGoogleChannelConfigRequest actualRequest =
        ((GetGoogleChannelConfigRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getGoogleChannelConfigExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockEventarc.addException(exception);

    try {
      String name = "name3373707";
      client.getGoogleChannelConfig(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updateGoogleChannelConfigTest() throws Exception {
    GoogleChannelConfig expectedResponse =
        GoogleChannelConfig.newBuilder()
            .setName(GoogleChannelConfigName.of("[PROJECT]", "[LOCATION]").toString())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setCryptoKeyName("cryptoKeyName1447084425")
            .build();
    mockEventarc.addResponse(expectedResponse);

    GoogleChannelConfig googleChannelConfig = GoogleChannelConfig.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    GoogleChannelConfig actualResponse =
        client.updateGoogleChannelConfig(googleChannelConfig, updateMask);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockEventarc.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateGoogleChannelConfigRequest actualRequest =
        ((UpdateGoogleChannelConfigRequest) actualRequests.get(0));

    Assert.assertEquals(googleChannelConfig, actualRequest.getGoogleChannelConfig());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateGoogleChannelConfigExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockEventarc.addException(exception);

    try {
      GoogleChannelConfig googleChannelConfig = GoogleChannelConfig.newBuilder().build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateGoogleChannelConfig(googleChannelConfig, updateMask);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getMessageBusTest() throws Exception {
    MessageBus expectedResponse =
        MessageBus.newBuilder()
            .setName(MessageBusName.of("[PROJECT]", "[LOCATION]", "[MESSAGE_BUS]").toString())
            .setUid("uid115792")
            .setEtag("etag3123477")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .putAllAnnotations(new HashMap<String, String>())
            .setDisplayName("displayName1714148973")
            .setCryptoKeyName("cryptoKeyName1447084425")
            .setLoggingConfig(LoggingConfig.newBuilder().build())
            .build();
    mockEventarc.addResponse(expectedResponse);

    MessageBusName name = MessageBusName.of("[PROJECT]", "[LOCATION]", "[MESSAGE_BUS]");

    MessageBus actualResponse = client.getMessageBus(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockEventarc.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetMessageBusRequest actualRequest = ((GetMessageBusRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getMessageBusExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockEventarc.addException(exception);

    try {
      MessageBusName name = MessageBusName.of("[PROJECT]", "[LOCATION]", "[MESSAGE_BUS]");
      client.getMessageBus(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getMessageBusTest2() throws Exception {
    MessageBus expectedResponse =
        MessageBus.newBuilder()
            .setName(MessageBusName.of("[PROJECT]", "[LOCATION]", "[MESSAGE_BUS]").toString())
            .setUid("uid115792")
            .setEtag("etag3123477")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .putAllAnnotations(new HashMap<String, String>())
            .setDisplayName("displayName1714148973")
            .setCryptoKeyName("cryptoKeyName1447084425")
            .setLoggingConfig(LoggingConfig.newBuilder().build())
            .build();
    mockEventarc.addResponse(expectedResponse);

    String name = "name3373707";

    MessageBus actualResponse = client.getMessageBus(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockEventarc.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetMessageBusRequest actualRequest = ((GetMessageBusRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getMessageBusExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockEventarc.addException(exception);

    try {
      String name = "name3373707";
      client.getMessageBus(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listMessageBusesTest() throws Exception {
    MessageBus responsesElement = MessageBus.newBuilder().build();
    ListMessageBusesResponse expectedResponse =
        ListMessageBusesResponse.newBuilder()
            .setNextPageToken("")
            .addAllMessageBuses(Arrays.asList(responsesElement))
            .build();
    mockEventarc.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

    ListMessageBusesPagedResponse pagedListResponse = client.listMessageBuses(parent);

    List<MessageBus> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getMessageBusesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockEventarc.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListMessageBusesRequest actualRequest = ((ListMessageBusesRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listMessageBusesExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockEventarc.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      client.listMessageBuses(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listMessageBusesTest2() throws Exception {
    MessageBus responsesElement = MessageBus.newBuilder().build();
    ListMessageBusesResponse expectedResponse =
        ListMessageBusesResponse.newBuilder()
            .setNextPageToken("")
            .addAllMessageBuses(Arrays.asList(responsesElement))
            .build();
    mockEventarc.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListMessageBusesPagedResponse pagedListResponse = client.listMessageBuses(parent);

    List<MessageBus> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getMessageBusesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockEventarc.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListMessageBusesRequest actualRequest = ((ListMessageBusesRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listMessageBusesExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockEventarc.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listMessageBuses(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listMessageBusEnrollmentsTest() throws Exception {
    String responsesElement = "responsesElement-318365110";
    ListMessageBusEnrollmentsResponse expectedResponse =
        ListMessageBusEnrollmentsResponse.newBuilder()
            .setNextPageToken("")
            .addAllEnrollments(Arrays.asList(responsesElement))
            .build();
    mockEventarc.addResponse(expectedResponse);

    MessageBusName parent = MessageBusName.of("[PROJECT]", "[LOCATION]", "[MESSAGE_BUS]");

    ListMessageBusEnrollmentsPagedResponse pagedListResponse =
        client.listMessageBusEnrollments(parent);

    List<String> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getEnrollmentsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockEventarc.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListMessageBusEnrollmentsRequest actualRequest =
        ((ListMessageBusEnrollmentsRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listMessageBusEnrollmentsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockEventarc.addException(exception);

    try {
      MessageBusName parent = MessageBusName.of("[PROJECT]", "[LOCATION]", "[MESSAGE_BUS]");
      client.listMessageBusEnrollments(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listMessageBusEnrollmentsTest2() throws Exception {
    String responsesElement = "responsesElement-318365110";
    ListMessageBusEnrollmentsResponse expectedResponse =
        ListMessageBusEnrollmentsResponse.newBuilder()
            .setNextPageToken("")
            .addAllEnrollments(Arrays.asList(responsesElement))
            .build();
    mockEventarc.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListMessageBusEnrollmentsPagedResponse pagedListResponse =
        client.listMessageBusEnrollments(parent);

    List<String> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getEnrollmentsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockEventarc.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListMessageBusEnrollmentsRequest actualRequest =
        ((ListMessageBusEnrollmentsRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listMessageBusEnrollmentsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockEventarc.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listMessageBusEnrollments(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createMessageBusTest() throws Exception {
    MessageBus expectedResponse =
        MessageBus.newBuilder()
            .setName(MessageBusName.of("[PROJECT]", "[LOCATION]", "[MESSAGE_BUS]").toString())
            .setUid("uid115792")
            .setEtag("etag3123477")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .putAllAnnotations(new HashMap<String, String>())
            .setDisplayName("displayName1714148973")
            .setCryptoKeyName("cryptoKeyName1447084425")
            .setLoggingConfig(LoggingConfig.newBuilder().build())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createMessageBusTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockEventarc.addResponse(resultOperation);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
    MessageBus messageBus = MessageBus.newBuilder().build();
    String messageBusId = "messageBusId-1312824332";

    MessageBus actualResponse =
        client.createMessageBusAsync(parent, messageBus, messageBusId).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockEventarc.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateMessageBusRequest actualRequest = ((CreateMessageBusRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(messageBus, actualRequest.getMessageBus());
    Assert.assertEquals(messageBusId, actualRequest.getMessageBusId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createMessageBusExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockEventarc.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      MessageBus messageBus = MessageBus.newBuilder().build();
      String messageBusId = "messageBusId-1312824332";
      client.createMessageBusAsync(parent, messageBus, messageBusId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void createMessageBusTest2() throws Exception {
    MessageBus expectedResponse =
        MessageBus.newBuilder()
            .setName(MessageBusName.of("[PROJECT]", "[LOCATION]", "[MESSAGE_BUS]").toString())
            .setUid("uid115792")
            .setEtag("etag3123477")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .putAllAnnotations(new HashMap<String, String>())
            .setDisplayName("displayName1714148973")
            .setCryptoKeyName("cryptoKeyName1447084425")
            .setLoggingConfig(LoggingConfig.newBuilder().build())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createMessageBusTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockEventarc.addResponse(resultOperation);

    String parent = "parent-995424086";
    MessageBus messageBus = MessageBus.newBuilder().build();
    String messageBusId = "messageBusId-1312824332";

    MessageBus actualResponse =
        client.createMessageBusAsync(parent, messageBus, messageBusId).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockEventarc.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateMessageBusRequest actualRequest = ((CreateMessageBusRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(messageBus, actualRequest.getMessageBus());
    Assert.assertEquals(messageBusId, actualRequest.getMessageBusId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createMessageBusExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockEventarc.addException(exception);

    try {
      String parent = "parent-995424086";
      MessageBus messageBus = MessageBus.newBuilder().build();
      String messageBusId = "messageBusId-1312824332";
      client.createMessageBusAsync(parent, messageBus, messageBusId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void updateMessageBusTest() throws Exception {
    MessageBus expectedResponse =
        MessageBus.newBuilder()
            .setName(MessageBusName.of("[PROJECT]", "[LOCATION]", "[MESSAGE_BUS]").toString())
            .setUid("uid115792")
            .setEtag("etag3123477")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .putAllAnnotations(new HashMap<String, String>())
            .setDisplayName("displayName1714148973")
            .setCryptoKeyName("cryptoKeyName1447084425")
            .setLoggingConfig(LoggingConfig.newBuilder().build())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("updateMessageBusTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockEventarc.addResponse(resultOperation);

    MessageBus messageBus = MessageBus.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    MessageBus actualResponse = client.updateMessageBusAsync(messageBus, updateMask).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockEventarc.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateMessageBusRequest actualRequest = ((UpdateMessageBusRequest) actualRequests.get(0));

    Assert.assertEquals(messageBus, actualRequest.getMessageBus());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateMessageBusExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockEventarc.addException(exception);

    try {
      MessageBus messageBus = MessageBus.newBuilder().build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateMessageBusAsync(messageBus, updateMask).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void deleteMessageBusTest() throws Exception {
    MessageBus expectedResponse =
        MessageBus.newBuilder()
            .setName(MessageBusName.of("[PROJECT]", "[LOCATION]", "[MESSAGE_BUS]").toString())
            .setUid("uid115792")
            .setEtag("etag3123477")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .putAllAnnotations(new HashMap<String, String>())
            .setDisplayName("displayName1714148973")
            .setCryptoKeyName("cryptoKeyName1447084425")
            .setLoggingConfig(LoggingConfig.newBuilder().build())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteMessageBusTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockEventarc.addResponse(resultOperation);

    MessageBusName name = MessageBusName.of("[PROJECT]", "[LOCATION]", "[MESSAGE_BUS]");
    String etag = "etag3123477";

    MessageBus actualResponse = client.deleteMessageBusAsync(name, etag).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockEventarc.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteMessageBusRequest actualRequest = ((DeleteMessageBusRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertEquals(etag, actualRequest.getEtag());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteMessageBusExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockEventarc.addException(exception);

    try {
      MessageBusName name = MessageBusName.of("[PROJECT]", "[LOCATION]", "[MESSAGE_BUS]");
      String etag = "etag3123477";
      client.deleteMessageBusAsync(name, etag).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void deleteMessageBusTest2() throws Exception {
    MessageBus expectedResponse =
        MessageBus.newBuilder()
            .setName(MessageBusName.of("[PROJECT]", "[LOCATION]", "[MESSAGE_BUS]").toString())
            .setUid("uid115792")
            .setEtag("etag3123477")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .putAllAnnotations(new HashMap<String, String>())
            .setDisplayName("displayName1714148973")
            .setCryptoKeyName("cryptoKeyName1447084425")
            .setLoggingConfig(LoggingConfig.newBuilder().build())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteMessageBusTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockEventarc.addResponse(resultOperation);

    String name = "name3373707";
    String etag = "etag3123477";

    MessageBus actualResponse = client.deleteMessageBusAsync(name, etag).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockEventarc.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteMessageBusRequest actualRequest = ((DeleteMessageBusRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertEquals(etag, actualRequest.getEtag());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteMessageBusExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockEventarc.addException(exception);

    try {
      String name = "name3373707";
      String etag = "etag3123477";
      client.deleteMessageBusAsync(name, etag).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void getEnrollmentTest() throws Exception {
    Enrollment expectedResponse =
        Enrollment.newBuilder()
            .setName(EnrollmentName.of("[PROJECT]", "[LOCATION]", "[ENROLLMENT]").toString())
            .setUid("uid115792")
            .setEtag("etag3123477")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .putAllAnnotations(new HashMap<String, String>())
            .setDisplayName("displayName1714148973")
            .setCelMatch("celMatch-945813605")
            .setMessageBus(MessageBusName.of("[PROJECT]", "[LOCATION]", "[MESSAGE_BUS]").toString())
            .setDestination("destination-1429847026")
            .build();
    mockEventarc.addResponse(expectedResponse);

    EnrollmentName name = EnrollmentName.of("[PROJECT]", "[LOCATION]", "[ENROLLMENT]");

    Enrollment actualResponse = client.getEnrollment(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockEventarc.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetEnrollmentRequest actualRequest = ((GetEnrollmentRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getEnrollmentExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockEventarc.addException(exception);

    try {
      EnrollmentName name = EnrollmentName.of("[PROJECT]", "[LOCATION]", "[ENROLLMENT]");
      client.getEnrollment(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getEnrollmentTest2() throws Exception {
    Enrollment expectedResponse =
        Enrollment.newBuilder()
            .setName(EnrollmentName.of("[PROJECT]", "[LOCATION]", "[ENROLLMENT]").toString())
            .setUid("uid115792")
            .setEtag("etag3123477")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .putAllAnnotations(new HashMap<String, String>())
            .setDisplayName("displayName1714148973")
            .setCelMatch("celMatch-945813605")
            .setMessageBus(MessageBusName.of("[PROJECT]", "[LOCATION]", "[MESSAGE_BUS]").toString())
            .setDestination("destination-1429847026")
            .build();
    mockEventarc.addResponse(expectedResponse);

    String name = "name3373707";

    Enrollment actualResponse = client.getEnrollment(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockEventarc.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetEnrollmentRequest actualRequest = ((GetEnrollmentRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getEnrollmentExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockEventarc.addException(exception);

    try {
      String name = "name3373707";
      client.getEnrollment(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listEnrollmentsTest() throws Exception {
    Enrollment responsesElement = Enrollment.newBuilder().build();
    ListEnrollmentsResponse expectedResponse =
        ListEnrollmentsResponse.newBuilder()
            .setNextPageToken("")
            .addAllEnrollments(Arrays.asList(responsesElement))
            .build();
    mockEventarc.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

    ListEnrollmentsPagedResponse pagedListResponse = client.listEnrollments(parent);

    List<Enrollment> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getEnrollmentsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockEventarc.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListEnrollmentsRequest actualRequest = ((ListEnrollmentsRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listEnrollmentsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockEventarc.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      client.listEnrollments(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listEnrollmentsTest2() throws Exception {
    Enrollment responsesElement = Enrollment.newBuilder().build();
    ListEnrollmentsResponse expectedResponse =
        ListEnrollmentsResponse.newBuilder()
            .setNextPageToken("")
            .addAllEnrollments(Arrays.asList(responsesElement))
            .build();
    mockEventarc.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListEnrollmentsPagedResponse pagedListResponse = client.listEnrollments(parent);

    List<Enrollment> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getEnrollmentsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockEventarc.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListEnrollmentsRequest actualRequest = ((ListEnrollmentsRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listEnrollmentsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockEventarc.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listEnrollments(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createEnrollmentTest() throws Exception {
    Enrollment expectedResponse =
        Enrollment.newBuilder()
            .setName(EnrollmentName.of("[PROJECT]", "[LOCATION]", "[ENROLLMENT]").toString())
            .setUid("uid115792")
            .setEtag("etag3123477")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .putAllAnnotations(new HashMap<String, String>())
            .setDisplayName("displayName1714148973")
            .setCelMatch("celMatch-945813605")
            .setMessageBus(MessageBusName.of("[PROJECT]", "[LOCATION]", "[MESSAGE_BUS]").toString())
            .setDestination("destination-1429847026")
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createEnrollmentTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockEventarc.addResponse(resultOperation);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
    Enrollment enrollment = Enrollment.newBuilder().build();
    String enrollmentId = "enrollmentId-107037889";

    Enrollment actualResponse =
        client.createEnrollmentAsync(parent, enrollment, enrollmentId).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockEventarc.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateEnrollmentRequest actualRequest = ((CreateEnrollmentRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(enrollment, actualRequest.getEnrollment());
    Assert.assertEquals(enrollmentId, actualRequest.getEnrollmentId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createEnrollmentExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockEventarc.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      Enrollment enrollment = Enrollment.newBuilder().build();
      String enrollmentId = "enrollmentId-107037889";
      client.createEnrollmentAsync(parent, enrollment, enrollmentId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void createEnrollmentTest2() throws Exception {
    Enrollment expectedResponse =
        Enrollment.newBuilder()
            .setName(EnrollmentName.of("[PROJECT]", "[LOCATION]", "[ENROLLMENT]").toString())
            .setUid("uid115792")
            .setEtag("etag3123477")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .putAllAnnotations(new HashMap<String, String>())
            .setDisplayName("displayName1714148973")
            .setCelMatch("celMatch-945813605")
            .setMessageBus(MessageBusName.of("[PROJECT]", "[LOCATION]", "[MESSAGE_BUS]").toString())
            .setDestination("destination-1429847026")
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createEnrollmentTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockEventarc.addResponse(resultOperation);

    String parent = "parent-995424086";
    Enrollment enrollment = Enrollment.newBuilder().build();
    String enrollmentId = "enrollmentId-107037889";

    Enrollment actualResponse =
        client.createEnrollmentAsync(parent, enrollment, enrollmentId).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockEventarc.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateEnrollmentRequest actualRequest = ((CreateEnrollmentRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(enrollment, actualRequest.getEnrollment());
    Assert.assertEquals(enrollmentId, actualRequest.getEnrollmentId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createEnrollmentExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockEventarc.addException(exception);

    try {
      String parent = "parent-995424086";
      Enrollment enrollment = Enrollment.newBuilder().build();
      String enrollmentId = "enrollmentId-107037889";
      client.createEnrollmentAsync(parent, enrollment, enrollmentId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void updateEnrollmentTest() throws Exception {
    Enrollment expectedResponse =
        Enrollment.newBuilder()
            .setName(EnrollmentName.of("[PROJECT]", "[LOCATION]", "[ENROLLMENT]").toString())
            .setUid("uid115792")
            .setEtag("etag3123477")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .putAllAnnotations(new HashMap<String, String>())
            .setDisplayName("displayName1714148973")
            .setCelMatch("celMatch-945813605")
            .setMessageBus(MessageBusName.of("[PROJECT]", "[LOCATION]", "[MESSAGE_BUS]").toString())
            .setDestination("destination-1429847026")
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("updateEnrollmentTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockEventarc.addResponse(resultOperation);

    Enrollment enrollment = Enrollment.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    Enrollment actualResponse = client.updateEnrollmentAsync(enrollment, updateMask).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockEventarc.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateEnrollmentRequest actualRequest = ((UpdateEnrollmentRequest) actualRequests.get(0));

    Assert.assertEquals(enrollment, actualRequest.getEnrollment());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateEnrollmentExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockEventarc.addException(exception);

    try {
      Enrollment enrollment = Enrollment.newBuilder().build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateEnrollmentAsync(enrollment, updateMask).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void deleteEnrollmentTest() throws Exception {
    Enrollment expectedResponse =
        Enrollment.newBuilder()
            .setName(EnrollmentName.of("[PROJECT]", "[LOCATION]", "[ENROLLMENT]").toString())
            .setUid("uid115792")
            .setEtag("etag3123477")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .putAllAnnotations(new HashMap<String, String>())
            .setDisplayName("displayName1714148973")
            .setCelMatch("celMatch-945813605")
            .setMessageBus(MessageBusName.of("[PROJECT]", "[LOCATION]", "[MESSAGE_BUS]").toString())
            .setDestination("destination-1429847026")
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteEnrollmentTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockEventarc.addResponse(resultOperation);

    EnrollmentName name = EnrollmentName.of("[PROJECT]", "[LOCATION]", "[ENROLLMENT]");
    String etag = "etag3123477";

    Enrollment actualResponse = client.deleteEnrollmentAsync(name, etag).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockEventarc.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteEnrollmentRequest actualRequest = ((DeleteEnrollmentRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertEquals(etag, actualRequest.getEtag());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteEnrollmentExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockEventarc.addException(exception);

    try {
      EnrollmentName name = EnrollmentName.of("[PROJECT]", "[LOCATION]", "[ENROLLMENT]");
      String etag = "etag3123477";
      client.deleteEnrollmentAsync(name, etag).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void deleteEnrollmentTest2() throws Exception {
    Enrollment expectedResponse =
        Enrollment.newBuilder()
            .setName(EnrollmentName.of("[PROJECT]", "[LOCATION]", "[ENROLLMENT]").toString())
            .setUid("uid115792")
            .setEtag("etag3123477")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .putAllAnnotations(new HashMap<String, String>())
            .setDisplayName("displayName1714148973")
            .setCelMatch("celMatch-945813605")
            .setMessageBus(MessageBusName.of("[PROJECT]", "[LOCATION]", "[MESSAGE_BUS]").toString())
            .setDestination("destination-1429847026")
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteEnrollmentTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockEventarc.addResponse(resultOperation);

    String name = "name3373707";
    String etag = "etag3123477";

    Enrollment actualResponse = client.deleteEnrollmentAsync(name, etag).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockEventarc.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteEnrollmentRequest actualRequest = ((DeleteEnrollmentRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertEquals(etag, actualRequest.getEtag());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteEnrollmentExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockEventarc.addException(exception);

    try {
      String name = "name3373707";
      String etag = "etag3123477";
      client.deleteEnrollmentAsync(name, etag).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void getPipelineTest() throws Exception {
    Pipeline expectedResponse =
        Pipeline.newBuilder()
            .setName(PipelineName.of("[PROJECT]", "[LOCATION]", "[PIPELINE]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setUid("uid115792")
            .putAllAnnotations(new HashMap<String, String>())
            .setDisplayName("displayName1714148973")
            .addAllDestinations(new ArrayList<Pipeline.Destination>())
            .addAllMediations(new ArrayList<Pipeline.Mediation>())
            .setCryptoKeyName("cryptoKeyName1447084425")
            .setInputPayloadFormat(Pipeline.MessagePayloadFormat.newBuilder().build())
            .setLoggingConfig(LoggingConfig.newBuilder().build())
            .setRetryPolicy(Pipeline.RetryPolicy.newBuilder().build())
            .setEtag("etag3123477")
            .build();
    mockEventarc.addResponse(expectedResponse);

    PipelineName name = PipelineName.of("[PROJECT]", "[LOCATION]", "[PIPELINE]");

    Pipeline actualResponse = client.getPipeline(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockEventarc.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetPipelineRequest actualRequest = ((GetPipelineRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getPipelineExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockEventarc.addException(exception);

    try {
      PipelineName name = PipelineName.of("[PROJECT]", "[LOCATION]", "[PIPELINE]");
      client.getPipeline(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getPipelineTest2() throws Exception {
    Pipeline expectedResponse =
        Pipeline.newBuilder()
            .setName(PipelineName.of("[PROJECT]", "[LOCATION]", "[PIPELINE]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setUid("uid115792")
            .putAllAnnotations(new HashMap<String, String>())
            .setDisplayName("displayName1714148973")
            .addAllDestinations(new ArrayList<Pipeline.Destination>())
            .addAllMediations(new ArrayList<Pipeline.Mediation>())
            .setCryptoKeyName("cryptoKeyName1447084425")
            .setInputPayloadFormat(Pipeline.MessagePayloadFormat.newBuilder().build())
            .setLoggingConfig(LoggingConfig.newBuilder().build())
            .setRetryPolicy(Pipeline.RetryPolicy.newBuilder().build())
            .setEtag("etag3123477")
            .build();
    mockEventarc.addResponse(expectedResponse);

    String name = "name3373707";

    Pipeline actualResponse = client.getPipeline(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockEventarc.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetPipelineRequest actualRequest = ((GetPipelineRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getPipelineExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockEventarc.addException(exception);

    try {
      String name = "name3373707";
      client.getPipeline(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listPipelinesTest() throws Exception {
    Pipeline responsesElement = Pipeline.newBuilder().build();
    ListPipelinesResponse expectedResponse =
        ListPipelinesResponse.newBuilder()
            .setNextPageToken("")
            .addAllPipelines(Arrays.asList(responsesElement))
            .build();
    mockEventarc.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

    ListPipelinesPagedResponse pagedListResponse = client.listPipelines(parent);

    List<Pipeline> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getPipelinesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockEventarc.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListPipelinesRequest actualRequest = ((ListPipelinesRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listPipelinesExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockEventarc.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      client.listPipelines(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listPipelinesTest2() throws Exception {
    Pipeline responsesElement = Pipeline.newBuilder().build();
    ListPipelinesResponse expectedResponse =
        ListPipelinesResponse.newBuilder()
            .setNextPageToken("")
            .addAllPipelines(Arrays.asList(responsesElement))
            .build();
    mockEventarc.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListPipelinesPagedResponse pagedListResponse = client.listPipelines(parent);

    List<Pipeline> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getPipelinesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockEventarc.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListPipelinesRequest actualRequest = ((ListPipelinesRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listPipelinesExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockEventarc.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listPipelines(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createPipelineTest() throws Exception {
    Pipeline expectedResponse =
        Pipeline.newBuilder()
            .setName(PipelineName.of("[PROJECT]", "[LOCATION]", "[PIPELINE]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setUid("uid115792")
            .putAllAnnotations(new HashMap<String, String>())
            .setDisplayName("displayName1714148973")
            .addAllDestinations(new ArrayList<Pipeline.Destination>())
            .addAllMediations(new ArrayList<Pipeline.Mediation>())
            .setCryptoKeyName("cryptoKeyName1447084425")
            .setInputPayloadFormat(Pipeline.MessagePayloadFormat.newBuilder().build())
            .setLoggingConfig(LoggingConfig.newBuilder().build())
            .setRetryPolicy(Pipeline.RetryPolicy.newBuilder().build())
            .setEtag("etag3123477")
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createPipelineTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockEventarc.addResponse(resultOperation);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
    Pipeline pipeline = Pipeline.newBuilder().build();
    String pipelineId = "pipelineId-1076718755";

    Pipeline actualResponse = client.createPipelineAsync(parent, pipeline, pipelineId).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockEventarc.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreatePipelineRequest actualRequest = ((CreatePipelineRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(pipeline, actualRequest.getPipeline());
    Assert.assertEquals(pipelineId, actualRequest.getPipelineId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createPipelineExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockEventarc.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      Pipeline pipeline = Pipeline.newBuilder().build();
      String pipelineId = "pipelineId-1076718755";
      client.createPipelineAsync(parent, pipeline, pipelineId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void createPipelineTest2() throws Exception {
    Pipeline expectedResponse =
        Pipeline.newBuilder()
            .setName(PipelineName.of("[PROJECT]", "[LOCATION]", "[PIPELINE]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setUid("uid115792")
            .putAllAnnotations(new HashMap<String, String>())
            .setDisplayName("displayName1714148973")
            .addAllDestinations(new ArrayList<Pipeline.Destination>())
            .addAllMediations(new ArrayList<Pipeline.Mediation>())
            .setCryptoKeyName("cryptoKeyName1447084425")
            .setInputPayloadFormat(Pipeline.MessagePayloadFormat.newBuilder().build())
            .setLoggingConfig(LoggingConfig.newBuilder().build())
            .setRetryPolicy(Pipeline.RetryPolicy.newBuilder().build())
            .setEtag("etag3123477")
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createPipelineTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockEventarc.addResponse(resultOperation);

    String parent = "parent-995424086";
    Pipeline pipeline = Pipeline.newBuilder().build();
    String pipelineId = "pipelineId-1076718755";

    Pipeline actualResponse = client.createPipelineAsync(parent, pipeline, pipelineId).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockEventarc.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreatePipelineRequest actualRequest = ((CreatePipelineRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(pipeline, actualRequest.getPipeline());
    Assert.assertEquals(pipelineId, actualRequest.getPipelineId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createPipelineExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockEventarc.addException(exception);

    try {
      String parent = "parent-995424086";
      Pipeline pipeline = Pipeline.newBuilder().build();
      String pipelineId = "pipelineId-1076718755";
      client.createPipelineAsync(parent, pipeline, pipelineId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void updatePipelineTest() throws Exception {
    Pipeline expectedResponse =
        Pipeline.newBuilder()
            .setName(PipelineName.of("[PROJECT]", "[LOCATION]", "[PIPELINE]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setUid("uid115792")
            .putAllAnnotations(new HashMap<String, String>())
            .setDisplayName("displayName1714148973")
            .addAllDestinations(new ArrayList<Pipeline.Destination>())
            .addAllMediations(new ArrayList<Pipeline.Mediation>())
            .setCryptoKeyName("cryptoKeyName1447084425")
            .setInputPayloadFormat(Pipeline.MessagePayloadFormat.newBuilder().build())
            .setLoggingConfig(LoggingConfig.newBuilder().build())
            .setRetryPolicy(Pipeline.RetryPolicy.newBuilder().build())
            .setEtag("etag3123477")
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("updatePipelineTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockEventarc.addResponse(resultOperation);

    Pipeline pipeline = Pipeline.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    Pipeline actualResponse = client.updatePipelineAsync(pipeline, updateMask).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockEventarc.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdatePipelineRequest actualRequest = ((UpdatePipelineRequest) actualRequests.get(0));

    Assert.assertEquals(pipeline, actualRequest.getPipeline());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updatePipelineExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockEventarc.addException(exception);

    try {
      Pipeline pipeline = Pipeline.newBuilder().build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updatePipelineAsync(pipeline, updateMask).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void deletePipelineTest() throws Exception {
    Pipeline expectedResponse =
        Pipeline.newBuilder()
            .setName(PipelineName.of("[PROJECT]", "[LOCATION]", "[PIPELINE]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setUid("uid115792")
            .putAllAnnotations(new HashMap<String, String>())
            .setDisplayName("displayName1714148973")
            .addAllDestinations(new ArrayList<Pipeline.Destination>())
            .addAllMediations(new ArrayList<Pipeline.Mediation>())
            .setCryptoKeyName("cryptoKeyName1447084425")
            .setInputPayloadFormat(Pipeline.MessagePayloadFormat.newBuilder().build())
            .setLoggingConfig(LoggingConfig.newBuilder().build())
            .setRetryPolicy(Pipeline.RetryPolicy.newBuilder().build())
            .setEtag("etag3123477")
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deletePipelineTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockEventarc.addResponse(resultOperation);

    PipelineName name = PipelineName.of("[PROJECT]", "[LOCATION]", "[PIPELINE]");
    String etag = "etag3123477";

    Pipeline actualResponse = client.deletePipelineAsync(name, etag).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockEventarc.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeletePipelineRequest actualRequest = ((DeletePipelineRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertEquals(etag, actualRequest.getEtag());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deletePipelineExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockEventarc.addException(exception);

    try {
      PipelineName name = PipelineName.of("[PROJECT]", "[LOCATION]", "[PIPELINE]");
      String etag = "etag3123477";
      client.deletePipelineAsync(name, etag).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void deletePipelineTest2() throws Exception {
    Pipeline expectedResponse =
        Pipeline.newBuilder()
            .setName(PipelineName.of("[PROJECT]", "[LOCATION]", "[PIPELINE]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setUid("uid115792")
            .putAllAnnotations(new HashMap<String, String>())
            .setDisplayName("displayName1714148973")
            .addAllDestinations(new ArrayList<Pipeline.Destination>())
            .addAllMediations(new ArrayList<Pipeline.Mediation>())
            .setCryptoKeyName("cryptoKeyName1447084425")
            .setInputPayloadFormat(Pipeline.MessagePayloadFormat.newBuilder().build())
            .setLoggingConfig(LoggingConfig.newBuilder().build())
            .setRetryPolicy(Pipeline.RetryPolicy.newBuilder().build())
            .setEtag("etag3123477")
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deletePipelineTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockEventarc.addResponse(resultOperation);

    String name = "name3373707";
    String etag = "etag3123477";

    Pipeline actualResponse = client.deletePipelineAsync(name, etag).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockEventarc.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeletePipelineRequest actualRequest = ((DeletePipelineRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertEquals(etag, actualRequest.getEtag());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deletePipelineExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockEventarc.addException(exception);

    try {
      String name = "name3373707";
      String etag = "etag3123477";
      client.deletePipelineAsync(name, etag).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void getGoogleApiSourceTest() throws Exception {
    GoogleApiSource expectedResponse =
        GoogleApiSource.newBuilder()
            .setName(
                GoogleApiSourceName.of("[PROJECT]", "[LOCATION]", "[GOOGLE_API_SOURCE]").toString())
            .setUid("uid115792")
            .setEtag("etag3123477")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .putAllAnnotations(new HashMap<String, String>())
            .setDisplayName("displayName1714148973")
            .setDestination(
                MessageBusName.of("[PROJECT]", "[LOCATION]", "[MESSAGE_BUS]").toString())
            .setCryptoKeyName("cryptoKeyName1447084425")
            .setLoggingConfig(LoggingConfig.newBuilder().build())
            .build();
    mockEventarc.addResponse(expectedResponse);

    GoogleApiSourceName name =
        GoogleApiSourceName.of("[PROJECT]", "[LOCATION]", "[GOOGLE_API_SOURCE]");

    GoogleApiSource actualResponse = client.getGoogleApiSource(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockEventarc.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetGoogleApiSourceRequest actualRequest = ((GetGoogleApiSourceRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getGoogleApiSourceExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockEventarc.addException(exception);

    try {
      GoogleApiSourceName name =
          GoogleApiSourceName.of("[PROJECT]", "[LOCATION]", "[GOOGLE_API_SOURCE]");
      client.getGoogleApiSource(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getGoogleApiSourceTest2() throws Exception {
    GoogleApiSource expectedResponse =
        GoogleApiSource.newBuilder()
            .setName(
                GoogleApiSourceName.of("[PROJECT]", "[LOCATION]", "[GOOGLE_API_SOURCE]").toString())
            .setUid("uid115792")
            .setEtag("etag3123477")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .putAllAnnotations(new HashMap<String, String>())
            .setDisplayName("displayName1714148973")
            .setDestination(
                MessageBusName.of("[PROJECT]", "[LOCATION]", "[MESSAGE_BUS]").toString())
            .setCryptoKeyName("cryptoKeyName1447084425")
            .setLoggingConfig(LoggingConfig.newBuilder().build())
            .build();
    mockEventarc.addResponse(expectedResponse);

    String name = "name3373707";

    GoogleApiSource actualResponse = client.getGoogleApiSource(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockEventarc.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetGoogleApiSourceRequest actualRequest = ((GetGoogleApiSourceRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getGoogleApiSourceExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockEventarc.addException(exception);

    try {
      String name = "name3373707";
      client.getGoogleApiSource(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listGoogleApiSourcesTest() throws Exception {
    GoogleApiSource responsesElement = GoogleApiSource.newBuilder().build();
    ListGoogleApiSourcesResponse expectedResponse =
        ListGoogleApiSourcesResponse.newBuilder()
            .setNextPageToken("")
            .addAllGoogleApiSources(Arrays.asList(responsesElement))
            .build();
    mockEventarc.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

    ListGoogleApiSourcesPagedResponse pagedListResponse = client.listGoogleApiSources(parent);

    List<GoogleApiSource> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getGoogleApiSourcesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockEventarc.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListGoogleApiSourcesRequest actualRequest =
        ((ListGoogleApiSourcesRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listGoogleApiSourcesExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockEventarc.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      client.listGoogleApiSources(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listGoogleApiSourcesTest2() throws Exception {
    GoogleApiSource responsesElement = GoogleApiSource.newBuilder().build();
    ListGoogleApiSourcesResponse expectedResponse =
        ListGoogleApiSourcesResponse.newBuilder()
            .setNextPageToken("")
            .addAllGoogleApiSources(Arrays.asList(responsesElement))
            .build();
    mockEventarc.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListGoogleApiSourcesPagedResponse pagedListResponse = client.listGoogleApiSources(parent);

    List<GoogleApiSource> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getGoogleApiSourcesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockEventarc.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListGoogleApiSourcesRequest actualRequest =
        ((ListGoogleApiSourcesRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listGoogleApiSourcesExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockEventarc.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listGoogleApiSources(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createGoogleApiSourceTest() throws Exception {
    GoogleApiSource expectedResponse =
        GoogleApiSource.newBuilder()
            .setName(
                GoogleApiSourceName.of("[PROJECT]", "[LOCATION]", "[GOOGLE_API_SOURCE]").toString())
            .setUid("uid115792")
            .setEtag("etag3123477")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .putAllAnnotations(new HashMap<String, String>())
            .setDisplayName("displayName1714148973")
            .setDestination(
                MessageBusName.of("[PROJECT]", "[LOCATION]", "[MESSAGE_BUS]").toString())
            .setCryptoKeyName("cryptoKeyName1447084425")
            .setLoggingConfig(LoggingConfig.newBuilder().build())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createGoogleApiSourceTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockEventarc.addResponse(resultOperation);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
    GoogleApiSource googleApiSource = GoogleApiSource.newBuilder().build();
    String googleApiSourceId = "googleApiSourceId-1417062697";

    GoogleApiSource actualResponse =
        client.createGoogleApiSourceAsync(parent, googleApiSource, googleApiSourceId).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockEventarc.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateGoogleApiSourceRequest actualRequest =
        ((CreateGoogleApiSourceRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(googleApiSource, actualRequest.getGoogleApiSource());
    Assert.assertEquals(googleApiSourceId, actualRequest.getGoogleApiSourceId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createGoogleApiSourceExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockEventarc.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      GoogleApiSource googleApiSource = GoogleApiSource.newBuilder().build();
      String googleApiSourceId = "googleApiSourceId-1417062697";
      client.createGoogleApiSourceAsync(parent, googleApiSource, googleApiSourceId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void createGoogleApiSourceTest2() throws Exception {
    GoogleApiSource expectedResponse =
        GoogleApiSource.newBuilder()
            .setName(
                GoogleApiSourceName.of("[PROJECT]", "[LOCATION]", "[GOOGLE_API_SOURCE]").toString())
            .setUid("uid115792")
            .setEtag("etag3123477")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .putAllAnnotations(new HashMap<String, String>())
            .setDisplayName("displayName1714148973")
            .setDestination(
                MessageBusName.of("[PROJECT]", "[LOCATION]", "[MESSAGE_BUS]").toString())
            .setCryptoKeyName("cryptoKeyName1447084425")
            .setLoggingConfig(LoggingConfig.newBuilder().build())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createGoogleApiSourceTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockEventarc.addResponse(resultOperation);

    String parent = "parent-995424086";
    GoogleApiSource googleApiSource = GoogleApiSource.newBuilder().build();
    String googleApiSourceId = "googleApiSourceId-1417062697";

    GoogleApiSource actualResponse =
        client.createGoogleApiSourceAsync(parent, googleApiSource, googleApiSourceId).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockEventarc.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateGoogleApiSourceRequest actualRequest =
        ((CreateGoogleApiSourceRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(googleApiSource, actualRequest.getGoogleApiSource());
    Assert.assertEquals(googleApiSourceId, actualRequest.getGoogleApiSourceId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createGoogleApiSourceExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockEventarc.addException(exception);

    try {
      String parent = "parent-995424086";
      GoogleApiSource googleApiSource = GoogleApiSource.newBuilder().build();
      String googleApiSourceId = "googleApiSourceId-1417062697";
      client.createGoogleApiSourceAsync(parent, googleApiSource, googleApiSourceId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void updateGoogleApiSourceTest() throws Exception {
    GoogleApiSource expectedResponse =
        GoogleApiSource.newBuilder()
            .setName(
                GoogleApiSourceName.of("[PROJECT]", "[LOCATION]", "[GOOGLE_API_SOURCE]").toString())
            .setUid("uid115792")
            .setEtag("etag3123477")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .putAllAnnotations(new HashMap<String, String>())
            .setDisplayName("displayName1714148973")
            .setDestination(
                MessageBusName.of("[PROJECT]", "[LOCATION]", "[MESSAGE_BUS]").toString())
            .setCryptoKeyName("cryptoKeyName1447084425")
            .setLoggingConfig(LoggingConfig.newBuilder().build())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("updateGoogleApiSourceTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockEventarc.addResponse(resultOperation);

    GoogleApiSource googleApiSource = GoogleApiSource.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    GoogleApiSource actualResponse =
        client.updateGoogleApiSourceAsync(googleApiSource, updateMask).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockEventarc.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateGoogleApiSourceRequest actualRequest =
        ((UpdateGoogleApiSourceRequest) actualRequests.get(0));

    Assert.assertEquals(googleApiSource, actualRequest.getGoogleApiSource());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateGoogleApiSourceExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockEventarc.addException(exception);

    try {
      GoogleApiSource googleApiSource = GoogleApiSource.newBuilder().build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateGoogleApiSourceAsync(googleApiSource, updateMask).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void deleteGoogleApiSourceTest() throws Exception {
    GoogleApiSource expectedResponse =
        GoogleApiSource.newBuilder()
            .setName(
                GoogleApiSourceName.of("[PROJECT]", "[LOCATION]", "[GOOGLE_API_SOURCE]").toString())
            .setUid("uid115792")
            .setEtag("etag3123477")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .putAllAnnotations(new HashMap<String, String>())
            .setDisplayName("displayName1714148973")
            .setDestination(
                MessageBusName.of("[PROJECT]", "[LOCATION]", "[MESSAGE_BUS]").toString())
            .setCryptoKeyName("cryptoKeyName1447084425")
            .setLoggingConfig(LoggingConfig.newBuilder().build())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteGoogleApiSourceTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockEventarc.addResponse(resultOperation);

    GoogleApiSourceName name =
        GoogleApiSourceName.of("[PROJECT]", "[LOCATION]", "[GOOGLE_API_SOURCE]");
    String etag = "etag3123477";

    GoogleApiSource actualResponse = client.deleteGoogleApiSourceAsync(name, etag).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockEventarc.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteGoogleApiSourceRequest actualRequest =
        ((DeleteGoogleApiSourceRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertEquals(etag, actualRequest.getEtag());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteGoogleApiSourceExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockEventarc.addException(exception);

    try {
      GoogleApiSourceName name =
          GoogleApiSourceName.of("[PROJECT]", "[LOCATION]", "[GOOGLE_API_SOURCE]");
      String etag = "etag3123477";
      client.deleteGoogleApiSourceAsync(name, etag).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void deleteGoogleApiSourceTest2() throws Exception {
    GoogleApiSource expectedResponse =
        GoogleApiSource.newBuilder()
            .setName(
                GoogleApiSourceName.of("[PROJECT]", "[LOCATION]", "[GOOGLE_API_SOURCE]").toString())
            .setUid("uid115792")
            .setEtag("etag3123477")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .putAllAnnotations(new HashMap<String, String>())
            .setDisplayName("displayName1714148973")
            .setDestination(
                MessageBusName.of("[PROJECT]", "[LOCATION]", "[MESSAGE_BUS]").toString())
            .setCryptoKeyName("cryptoKeyName1447084425")
            .setLoggingConfig(LoggingConfig.newBuilder().build())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteGoogleApiSourceTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockEventarc.addResponse(resultOperation);

    String name = "name3373707";
    String etag = "etag3123477";

    GoogleApiSource actualResponse = client.deleteGoogleApiSourceAsync(name, etag).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockEventarc.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteGoogleApiSourceRequest actualRequest =
        ((DeleteGoogleApiSourceRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertEquals(etag, actualRequest.getEtag());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteGoogleApiSourceExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockEventarc.addException(exception);

    try {
      String name = "name3373707";
      String etag = "etag3123477";
      client.deleteGoogleApiSourceAsync(name, etag).get();
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

  @Test
  public void setIamPolicyTest() throws Exception {
    Policy expectedResponse =
        Policy.newBuilder()
            .setVersion(351608024)
            .addAllBindings(new ArrayList<Binding>())
            .addAllAuditConfigs(new ArrayList<AuditConfig>())
            .setEtag(ByteString.EMPTY)
            .build();
    mockIAMPolicy.addResponse(expectedResponse);

    SetIamPolicyRequest request =
        SetIamPolicyRequest.newBuilder()
            .setResource(ChannelName.of("[PROJECT]", "[LOCATION]", "[CHANNEL]").toString())
            .setPolicy(Policy.newBuilder().build())
            .setUpdateMask(FieldMask.newBuilder().build())
            .build();

    Policy actualResponse = client.setIamPolicy(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockIAMPolicy.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    SetIamPolicyRequest actualRequest = ((SetIamPolicyRequest) actualRequests.get(0));

    Assert.assertEquals(request.getResource(), actualRequest.getResource());
    Assert.assertEquals(request.getPolicy(), actualRequest.getPolicy());
    Assert.assertEquals(request.getUpdateMask(), actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void setIamPolicyExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockIAMPolicy.addException(exception);

    try {
      SetIamPolicyRequest request =
          SetIamPolicyRequest.newBuilder()
              .setResource(ChannelName.of("[PROJECT]", "[LOCATION]", "[CHANNEL]").toString())
              .setPolicy(Policy.newBuilder().build())
              .setUpdateMask(FieldMask.newBuilder().build())
              .build();
      client.setIamPolicy(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getIamPolicyTest() throws Exception {
    Policy expectedResponse =
        Policy.newBuilder()
            .setVersion(351608024)
            .addAllBindings(new ArrayList<Binding>())
            .addAllAuditConfigs(new ArrayList<AuditConfig>())
            .setEtag(ByteString.EMPTY)
            .build();
    mockIAMPolicy.addResponse(expectedResponse);

    GetIamPolicyRequest request =
        GetIamPolicyRequest.newBuilder()
            .setResource(ChannelName.of("[PROJECT]", "[LOCATION]", "[CHANNEL]").toString())
            .setOptions(GetPolicyOptions.newBuilder().build())
            .build();

    Policy actualResponse = client.getIamPolicy(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockIAMPolicy.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetIamPolicyRequest actualRequest = ((GetIamPolicyRequest) actualRequests.get(0));

    Assert.assertEquals(request.getResource(), actualRequest.getResource());
    Assert.assertEquals(request.getOptions(), actualRequest.getOptions());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getIamPolicyExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockIAMPolicy.addException(exception);

    try {
      GetIamPolicyRequest request =
          GetIamPolicyRequest.newBuilder()
              .setResource(ChannelName.of("[PROJECT]", "[LOCATION]", "[CHANNEL]").toString())
              .setOptions(GetPolicyOptions.newBuilder().build())
              .build();
      client.getIamPolicy(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void testIamPermissionsTest() throws Exception {
    TestIamPermissionsResponse expectedResponse =
        TestIamPermissionsResponse.newBuilder().addAllPermissions(new ArrayList<String>()).build();
    mockIAMPolicy.addResponse(expectedResponse);

    TestIamPermissionsRequest request =
        TestIamPermissionsRequest.newBuilder()
            .setResource(ChannelName.of("[PROJECT]", "[LOCATION]", "[CHANNEL]").toString())
            .addAllPermissions(new ArrayList<String>())
            .build();

    TestIamPermissionsResponse actualResponse = client.testIamPermissions(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockIAMPolicy.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    TestIamPermissionsRequest actualRequest = ((TestIamPermissionsRequest) actualRequests.get(0));

    Assert.assertEquals(request.getResource(), actualRequest.getResource());
    Assert.assertEquals(request.getPermissionsList(), actualRequest.getPermissionsList());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void testIamPermissionsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockIAMPolicy.addException(exception);

    try {
      TestIamPermissionsRequest request =
          TestIamPermissionsRequest.newBuilder()
              .setResource(ChannelName.of("[PROJECT]", "[LOCATION]", "[CHANNEL]").toString())
              .addAllPermissions(new ArrayList<String>())
              .build();
      client.testIamPermissions(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
