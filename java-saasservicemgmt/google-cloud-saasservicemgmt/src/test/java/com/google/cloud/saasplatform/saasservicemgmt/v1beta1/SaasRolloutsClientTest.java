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

package com.google.cloud.saasplatform.saasservicemgmt.v1beta1;

import static com.google.cloud.saasplatform.saasservicemgmt.v1beta1.SaasRolloutsClient.ListLocationsPagedResponse;
import static com.google.cloud.saasplatform.saasservicemgmt.v1beta1.SaasRolloutsClient.ListRolloutKindsPagedResponse;
import static com.google.cloud.saasplatform.saasservicemgmt.v1beta1.SaasRolloutsClient.ListRolloutsPagedResponse;

import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.grpc.GaxGrpcProperties;
import com.google.api.gax.grpc.testing.LocalChannelProvider;
import com.google.api.gax.grpc.testing.MockGrpcService;
import com.google.api.gax.grpc.testing.MockServiceHelper;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
import com.google.common.collect.Lists;
import com.google.protobuf.AbstractMessage;
import com.google.protobuf.Any;
import com.google.protobuf.Empty;
import com.google.protobuf.FieldMask;
import com.google.protobuf.Timestamp;
import io.grpc.StatusRuntimeException;
import java.io.IOException;
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
public class SaasRolloutsClientTest {
  private static MockLocations mockLocations;
  private static MockSaasRollouts mockSaasRollouts;
  private static MockServiceHelper mockServiceHelper;
  private LocalChannelProvider channelProvider;
  private SaasRolloutsClient client;

  @BeforeClass
  public static void startStaticServer() {
    mockSaasRollouts = new MockSaasRollouts();
    mockLocations = new MockLocations();
    mockServiceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(),
            Arrays.<MockGrpcService>asList(mockSaasRollouts, mockLocations));
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
    SaasRolloutsSettings settings =
        SaasRolloutsSettings.newBuilder()
            .setTransportChannelProvider(channelProvider)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = SaasRolloutsClient.create(settings);
  }

  @After
  public void tearDown() throws Exception {
    client.close();
  }

  @Test
  public void listRolloutsTest() throws Exception {
    Rollout responsesElement = Rollout.newBuilder().build();
    ListRolloutsResponse expectedResponse =
        ListRolloutsResponse.newBuilder()
            .setNextPageToken("")
            .addAllRollouts(Arrays.asList(responsesElement))
            .build();
    mockSaasRollouts.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

    ListRolloutsPagedResponse pagedListResponse = client.listRollouts(parent);

    List<Rollout> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getRolloutsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockSaasRollouts.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListRolloutsRequest actualRequest = ((ListRolloutsRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listRolloutsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSaasRollouts.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      client.listRollouts(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listRolloutsTest2() throws Exception {
    Rollout responsesElement = Rollout.newBuilder().build();
    ListRolloutsResponse expectedResponse =
        ListRolloutsResponse.newBuilder()
            .setNextPageToken("")
            .addAllRollouts(Arrays.asList(responsesElement))
            .build();
    mockSaasRollouts.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListRolloutsPagedResponse pagedListResponse = client.listRollouts(parent);

    List<Rollout> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getRolloutsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockSaasRollouts.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListRolloutsRequest actualRequest = ((ListRolloutsRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listRolloutsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSaasRollouts.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listRollouts(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getRolloutTest() throws Exception {
    Rollout expectedResponse =
        Rollout.newBuilder()
            .setName(RolloutName.of("[PROJECT]", "[LOCATION]", "[ROLLOUT_ID]").toString())
            .setRelease(ReleaseName.of("[PROJECT]", "[LOCATION]", "[RELEASE]").toString())
            .setStartTime(Timestamp.newBuilder().build())
            .setEndTime(Timestamp.newBuilder().build())
            .setStateMessage("stateMessage1128185398")
            .setStateTransitionTime(Timestamp.newBuilder().build())
            .setRootRollout(RolloutName.of("[PROJECT]", "[LOCATION]", "[ROLLOUT_ID]").toString())
            .setParentRollout(RolloutName.of("[PROJECT]", "[LOCATION]", "[ROLLOUT_ID]").toString())
            .setRolloutOrchestrationStrategy("rolloutOrchestrationStrategy-1543555165")
            .setUnitFilter("unitFilter1813274140")
            .setRolloutKind(
                RolloutKindName.of("[PROJECT]", "[LOCATION]", "[ROLLOUT_KIND_ID]").toString())
            .setStats(RolloutStats.newBuilder().build())
            .setControl(RolloutControl.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .putAllAnnotations(new HashMap<String, String>())
            .setUid("uid115792")
            .setEtag("etag3123477")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .build();
    mockSaasRollouts.addResponse(expectedResponse);

    RolloutName name = RolloutName.of("[PROJECT]", "[LOCATION]", "[ROLLOUT_ID]");

    Rollout actualResponse = client.getRollout(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockSaasRollouts.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetRolloutRequest actualRequest = ((GetRolloutRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getRolloutExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSaasRollouts.addException(exception);

    try {
      RolloutName name = RolloutName.of("[PROJECT]", "[LOCATION]", "[ROLLOUT_ID]");
      client.getRollout(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getRolloutTest2() throws Exception {
    Rollout expectedResponse =
        Rollout.newBuilder()
            .setName(RolloutName.of("[PROJECT]", "[LOCATION]", "[ROLLOUT_ID]").toString())
            .setRelease(ReleaseName.of("[PROJECT]", "[LOCATION]", "[RELEASE]").toString())
            .setStartTime(Timestamp.newBuilder().build())
            .setEndTime(Timestamp.newBuilder().build())
            .setStateMessage("stateMessage1128185398")
            .setStateTransitionTime(Timestamp.newBuilder().build())
            .setRootRollout(RolloutName.of("[PROJECT]", "[LOCATION]", "[ROLLOUT_ID]").toString())
            .setParentRollout(RolloutName.of("[PROJECT]", "[LOCATION]", "[ROLLOUT_ID]").toString())
            .setRolloutOrchestrationStrategy("rolloutOrchestrationStrategy-1543555165")
            .setUnitFilter("unitFilter1813274140")
            .setRolloutKind(
                RolloutKindName.of("[PROJECT]", "[LOCATION]", "[ROLLOUT_KIND_ID]").toString())
            .setStats(RolloutStats.newBuilder().build())
            .setControl(RolloutControl.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .putAllAnnotations(new HashMap<String, String>())
            .setUid("uid115792")
            .setEtag("etag3123477")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .build();
    mockSaasRollouts.addResponse(expectedResponse);

    String name = "name3373707";

    Rollout actualResponse = client.getRollout(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockSaasRollouts.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetRolloutRequest actualRequest = ((GetRolloutRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getRolloutExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSaasRollouts.addException(exception);

    try {
      String name = "name3373707";
      client.getRollout(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createRolloutTest() throws Exception {
    Rollout expectedResponse =
        Rollout.newBuilder()
            .setName(RolloutName.of("[PROJECT]", "[LOCATION]", "[ROLLOUT_ID]").toString())
            .setRelease(ReleaseName.of("[PROJECT]", "[LOCATION]", "[RELEASE]").toString())
            .setStartTime(Timestamp.newBuilder().build())
            .setEndTime(Timestamp.newBuilder().build())
            .setStateMessage("stateMessage1128185398")
            .setStateTransitionTime(Timestamp.newBuilder().build())
            .setRootRollout(RolloutName.of("[PROJECT]", "[LOCATION]", "[ROLLOUT_ID]").toString())
            .setParentRollout(RolloutName.of("[PROJECT]", "[LOCATION]", "[ROLLOUT_ID]").toString())
            .setRolloutOrchestrationStrategy("rolloutOrchestrationStrategy-1543555165")
            .setUnitFilter("unitFilter1813274140")
            .setRolloutKind(
                RolloutKindName.of("[PROJECT]", "[LOCATION]", "[ROLLOUT_KIND_ID]").toString())
            .setStats(RolloutStats.newBuilder().build())
            .setControl(RolloutControl.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .putAllAnnotations(new HashMap<String, String>())
            .setUid("uid115792")
            .setEtag("etag3123477")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .build();
    mockSaasRollouts.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
    Rollout rollout = Rollout.newBuilder().build();
    String rolloutId = "rolloutId551248556";

    Rollout actualResponse = client.createRollout(parent, rollout, rolloutId);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockSaasRollouts.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateRolloutRequest actualRequest = ((CreateRolloutRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(rollout, actualRequest.getRollout());
    Assert.assertEquals(rolloutId, actualRequest.getRolloutId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createRolloutExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSaasRollouts.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      Rollout rollout = Rollout.newBuilder().build();
      String rolloutId = "rolloutId551248556";
      client.createRollout(parent, rollout, rolloutId);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createRolloutTest2() throws Exception {
    Rollout expectedResponse =
        Rollout.newBuilder()
            .setName(RolloutName.of("[PROJECT]", "[LOCATION]", "[ROLLOUT_ID]").toString())
            .setRelease(ReleaseName.of("[PROJECT]", "[LOCATION]", "[RELEASE]").toString())
            .setStartTime(Timestamp.newBuilder().build())
            .setEndTime(Timestamp.newBuilder().build())
            .setStateMessage("stateMessage1128185398")
            .setStateTransitionTime(Timestamp.newBuilder().build())
            .setRootRollout(RolloutName.of("[PROJECT]", "[LOCATION]", "[ROLLOUT_ID]").toString())
            .setParentRollout(RolloutName.of("[PROJECT]", "[LOCATION]", "[ROLLOUT_ID]").toString())
            .setRolloutOrchestrationStrategy("rolloutOrchestrationStrategy-1543555165")
            .setUnitFilter("unitFilter1813274140")
            .setRolloutKind(
                RolloutKindName.of("[PROJECT]", "[LOCATION]", "[ROLLOUT_KIND_ID]").toString())
            .setStats(RolloutStats.newBuilder().build())
            .setControl(RolloutControl.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .putAllAnnotations(new HashMap<String, String>())
            .setUid("uid115792")
            .setEtag("etag3123477")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .build();
    mockSaasRollouts.addResponse(expectedResponse);

    String parent = "parent-995424086";
    Rollout rollout = Rollout.newBuilder().build();
    String rolloutId = "rolloutId551248556";

    Rollout actualResponse = client.createRollout(parent, rollout, rolloutId);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockSaasRollouts.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateRolloutRequest actualRequest = ((CreateRolloutRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(rollout, actualRequest.getRollout());
    Assert.assertEquals(rolloutId, actualRequest.getRolloutId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createRolloutExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSaasRollouts.addException(exception);

    try {
      String parent = "parent-995424086";
      Rollout rollout = Rollout.newBuilder().build();
      String rolloutId = "rolloutId551248556";
      client.createRollout(parent, rollout, rolloutId);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updateRolloutTest() throws Exception {
    Rollout expectedResponse =
        Rollout.newBuilder()
            .setName(RolloutName.of("[PROJECT]", "[LOCATION]", "[ROLLOUT_ID]").toString())
            .setRelease(ReleaseName.of("[PROJECT]", "[LOCATION]", "[RELEASE]").toString())
            .setStartTime(Timestamp.newBuilder().build())
            .setEndTime(Timestamp.newBuilder().build())
            .setStateMessage("stateMessage1128185398")
            .setStateTransitionTime(Timestamp.newBuilder().build())
            .setRootRollout(RolloutName.of("[PROJECT]", "[LOCATION]", "[ROLLOUT_ID]").toString())
            .setParentRollout(RolloutName.of("[PROJECT]", "[LOCATION]", "[ROLLOUT_ID]").toString())
            .setRolloutOrchestrationStrategy("rolloutOrchestrationStrategy-1543555165")
            .setUnitFilter("unitFilter1813274140")
            .setRolloutKind(
                RolloutKindName.of("[PROJECT]", "[LOCATION]", "[ROLLOUT_KIND_ID]").toString())
            .setStats(RolloutStats.newBuilder().build())
            .setControl(RolloutControl.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .putAllAnnotations(new HashMap<String, String>())
            .setUid("uid115792")
            .setEtag("etag3123477")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .build();
    mockSaasRollouts.addResponse(expectedResponse);

    Rollout rollout = Rollout.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    Rollout actualResponse = client.updateRollout(rollout, updateMask);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockSaasRollouts.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateRolloutRequest actualRequest = ((UpdateRolloutRequest) actualRequests.get(0));

    Assert.assertEquals(rollout, actualRequest.getRollout());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateRolloutExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSaasRollouts.addException(exception);

    try {
      Rollout rollout = Rollout.newBuilder().build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateRollout(rollout, updateMask);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteRolloutTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockSaasRollouts.addResponse(expectedResponse);

    RolloutName name = RolloutName.of("[PROJECT]", "[LOCATION]", "[ROLLOUT_ID]");

    client.deleteRollout(name);

    List<AbstractMessage> actualRequests = mockSaasRollouts.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteRolloutRequest actualRequest = ((DeleteRolloutRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteRolloutExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSaasRollouts.addException(exception);

    try {
      RolloutName name = RolloutName.of("[PROJECT]", "[LOCATION]", "[ROLLOUT_ID]");
      client.deleteRollout(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteRolloutTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockSaasRollouts.addResponse(expectedResponse);

    String name = "name3373707";

    client.deleteRollout(name);

    List<AbstractMessage> actualRequests = mockSaasRollouts.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteRolloutRequest actualRequest = ((DeleteRolloutRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteRolloutExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSaasRollouts.addException(exception);

    try {
      String name = "name3373707";
      client.deleteRollout(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listRolloutKindsTest() throws Exception {
    RolloutKind responsesElement = RolloutKind.newBuilder().build();
    ListRolloutKindsResponse expectedResponse =
        ListRolloutKindsResponse.newBuilder()
            .setNextPageToken("")
            .addAllRolloutKinds(Arrays.asList(responsesElement))
            .build();
    mockSaasRollouts.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

    ListRolloutKindsPagedResponse pagedListResponse = client.listRolloutKinds(parent);

    List<RolloutKind> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getRolloutKindsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockSaasRollouts.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListRolloutKindsRequest actualRequest = ((ListRolloutKindsRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listRolloutKindsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSaasRollouts.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      client.listRolloutKinds(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listRolloutKindsTest2() throws Exception {
    RolloutKind responsesElement = RolloutKind.newBuilder().build();
    ListRolloutKindsResponse expectedResponse =
        ListRolloutKindsResponse.newBuilder()
            .setNextPageToken("")
            .addAllRolloutKinds(Arrays.asList(responsesElement))
            .build();
    mockSaasRollouts.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListRolloutKindsPagedResponse pagedListResponse = client.listRolloutKinds(parent);

    List<RolloutKind> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getRolloutKindsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockSaasRollouts.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListRolloutKindsRequest actualRequest = ((ListRolloutKindsRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listRolloutKindsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSaasRollouts.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listRolloutKinds(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getRolloutKindTest() throws Exception {
    RolloutKind expectedResponse =
        RolloutKind.newBuilder()
            .setName(RolloutKindName.of("[PROJECT]", "[LOCATION]", "[ROLLOUT_KIND_ID]").toString())
            .setUnitKind(UnitKindName.of("[PROJECT]", "[LOCATION]", "[UNITKIND]").toString())
            .setRolloutOrchestrationStrategy("rolloutOrchestrationStrategy-1543555165")
            .setUnitFilter("unitFilter1813274140")
            .setErrorBudget(ErrorBudget.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .putAllAnnotations(new HashMap<String, String>())
            .setUid("uid115792")
            .setEtag("etag3123477")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .build();
    mockSaasRollouts.addResponse(expectedResponse);

    RolloutKindName name = RolloutKindName.of("[PROJECT]", "[LOCATION]", "[ROLLOUT_KIND_ID]");

    RolloutKind actualResponse = client.getRolloutKind(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockSaasRollouts.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetRolloutKindRequest actualRequest = ((GetRolloutKindRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getRolloutKindExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSaasRollouts.addException(exception);

    try {
      RolloutKindName name = RolloutKindName.of("[PROJECT]", "[LOCATION]", "[ROLLOUT_KIND_ID]");
      client.getRolloutKind(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getRolloutKindTest2() throws Exception {
    RolloutKind expectedResponse =
        RolloutKind.newBuilder()
            .setName(RolloutKindName.of("[PROJECT]", "[LOCATION]", "[ROLLOUT_KIND_ID]").toString())
            .setUnitKind(UnitKindName.of("[PROJECT]", "[LOCATION]", "[UNITKIND]").toString())
            .setRolloutOrchestrationStrategy("rolloutOrchestrationStrategy-1543555165")
            .setUnitFilter("unitFilter1813274140")
            .setErrorBudget(ErrorBudget.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .putAllAnnotations(new HashMap<String, String>())
            .setUid("uid115792")
            .setEtag("etag3123477")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .build();
    mockSaasRollouts.addResponse(expectedResponse);

    String name = "name3373707";

    RolloutKind actualResponse = client.getRolloutKind(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockSaasRollouts.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetRolloutKindRequest actualRequest = ((GetRolloutKindRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getRolloutKindExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSaasRollouts.addException(exception);

    try {
      String name = "name3373707";
      client.getRolloutKind(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createRolloutKindTest() throws Exception {
    RolloutKind expectedResponse =
        RolloutKind.newBuilder()
            .setName(RolloutKindName.of("[PROJECT]", "[LOCATION]", "[ROLLOUT_KIND_ID]").toString())
            .setUnitKind(UnitKindName.of("[PROJECT]", "[LOCATION]", "[UNITKIND]").toString())
            .setRolloutOrchestrationStrategy("rolloutOrchestrationStrategy-1543555165")
            .setUnitFilter("unitFilter1813274140")
            .setErrorBudget(ErrorBudget.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .putAllAnnotations(new HashMap<String, String>())
            .setUid("uid115792")
            .setEtag("etag3123477")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .build();
    mockSaasRollouts.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
    RolloutKind rolloutKind = RolloutKind.newBuilder().build();
    String rolloutKindId = "rolloutKindId-1380592416";

    RolloutKind actualResponse = client.createRolloutKind(parent, rolloutKind, rolloutKindId);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockSaasRollouts.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateRolloutKindRequest actualRequest = ((CreateRolloutKindRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(rolloutKind, actualRequest.getRolloutKind());
    Assert.assertEquals(rolloutKindId, actualRequest.getRolloutKindId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createRolloutKindExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSaasRollouts.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      RolloutKind rolloutKind = RolloutKind.newBuilder().build();
      String rolloutKindId = "rolloutKindId-1380592416";
      client.createRolloutKind(parent, rolloutKind, rolloutKindId);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createRolloutKindTest2() throws Exception {
    RolloutKind expectedResponse =
        RolloutKind.newBuilder()
            .setName(RolloutKindName.of("[PROJECT]", "[LOCATION]", "[ROLLOUT_KIND_ID]").toString())
            .setUnitKind(UnitKindName.of("[PROJECT]", "[LOCATION]", "[UNITKIND]").toString())
            .setRolloutOrchestrationStrategy("rolloutOrchestrationStrategy-1543555165")
            .setUnitFilter("unitFilter1813274140")
            .setErrorBudget(ErrorBudget.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .putAllAnnotations(new HashMap<String, String>())
            .setUid("uid115792")
            .setEtag("etag3123477")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .build();
    mockSaasRollouts.addResponse(expectedResponse);

    String parent = "parent-995424086";
    RolloutKind rolloutKind = RolloutKind.newBuilder().build();
    String rolloutKindId = "rolloutKindId-1380592416";

    RolloutKind actualResponse = client.createRolloutKind(parent, rolloutKind, rolloutKindId);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockSaasRollouts.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateRolloutKindRequest actualRequest = ((CreateRolloutKindRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(rolloutKind, actualRequest.getRolloutKind());
    Assert.assertEquals(rolloutKindId, actualRequest.getRolloutKindId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createRolloutKindExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSaasRollouts.addException(exception);

    try {
      String parent = "parent-995424086";
      RolloutKind rolloutKind = RolloutKind.newBuilder().build();
      String rolloutKindId = "rolloutKindId-1380592416";
      client.createRolloutKind(parent, rolloutKind, rolloutKindId);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updateRolloutKindTest() throws Exception {
    RolloutKind expectedResponse =
        RolloutKind.newBuilder()
            .setName(RolloutKindName.of("[PROJECT]", "[LOCATION]", "[ROLLOUT_KIND_ID]").toString())
            .setUnitKind(UnitKindName.of("[PROJECT]", "[LOCATION]", "[UNITKIND]").toString())
            .setRolloutOrchestrationStrategy("rolloutOrchestrationStrategy-1543555165")
            .setUnitFilter("unitFilter1813274140")
            .setErrorBudget(ErrorBudget.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .putAllAnnotations(new HashMap<String, String>())
            .setUid("uid115792")
            .setEtag("etag3123477")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .build();
    mockSaasRollouts.addResponse(expectedResponse);

    RolloutKind rolloutKind = RolloutKind.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    RolloutKind actualResponse = client.updateRolloutKind(rolloutKind, updateMask);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockSaasRollouts.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateRolloutKindRequest actualRequest = ((UpdateRolloutKindRequest) actualRequests.get(0));

    Assert.assertEquals(rolloutKind, actualRequest.getRolloutKind());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateRolloutKindExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSaasRollouts.addException(exception);

    try {
      RolloutKind rolloutKind = RolloutKind.newBuilder().build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateRolloutKind(rolloutKind, updateMask);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteRolloutKindTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockSaasRollouts.addResponse(expectedResponse);

    RolloutKindName name = RolloutKindName.of("[PROJECT]", "[LOCATION]", "[ROLLOUT_KIND_ID]");

    client.deleteRolloutKind(name);

    List<AbstractMessage> actualRequests = mockSaasRollouts.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteRolloutKindRequest actualRequest = ((DeleteRolloutKindRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteRolloutKindExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSaasRollouts.addException(exception);

    try {
      RolloutKindName name = RolloutKindName.of("[PROJECT]", "[LOCATION]", "[ROLLOUT_KIND_ID]");
      client.deleteRolloutKind(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteRolloutKindTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockSaasRollouts.addResponse(expectedResponse);

    String name = "name3373707";

    client.deleteRolloutKind(name);

    List<AbstractMessage> actualRequests = mockSaasRollouts.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteRolloutKindRequest actualRequest = ((DeleteRolloutKindRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteRolloutKindExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSaasRollouts.addException(exception);

    try {
      String name = "name3373707";
      client.deleteRolloutKind(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
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
