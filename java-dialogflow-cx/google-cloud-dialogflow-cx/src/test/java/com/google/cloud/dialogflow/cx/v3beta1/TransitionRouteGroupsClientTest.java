/*
 * Copyright 2020 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.google.cloud.dialogflow.cx.v3beta1;

import static com.google.cloud.dialogflow.cx.v3beta1.TransitionRouteGroupsClient.ListTransitionRouteGroupsPagedResponse;

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
import io.grpc.Status;
import io.grpc.StatusRuntimeException;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

@javax.annotation.Generated("by GAPIC")
public class TransitionRouteGroupsClientTest {
  private static MockPages mockPages;
  private static MockFlows mockFlows;
  private static MockAgents mockAgents;
  private static MockEntityTypes mockEntityTypes;
  private static MockEnvironments mockEnvironments;
  private static MockIntents mockIntents;
  private static MockSessionEntityTypes mockSessionEntityTypes;
  private static MockSessions mockSessions;
  private static MockTransitionRouteGroups mockTransitionRouteGroups;
  private static MockVersions mockVersions;
  private static MockWebhooks mockWebhooks;
  private static MockServiceHelper serviceHelper;
  private TransitionRouteGroupsClient client;
  private LocalChannelProvider channelProvider;

  @BeforeClass
  public static void startStaticServer() {
    mockPages = new MockPages();
    mockFlows = new MockFlows();
    mockAgents = new MockAgents();
    mockEntityTypes = new MockEntityTypes();
    mockEnvironments = new MockEnvironments();
    mockIntents = new MockIntents();
    mockSessionEntityTypes = new MockSessionEntityTypes();
    mockSessions = new MockSessions();
    mockTransitionRouteGroups = new MockTransitionRouteGroups();
    mockVersions = new MockVersions();
    mockWebhooks = new MockWebhooks();
    serviceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(),
            Arrays.<MockGrpcService>asList(
                mockPages,
                mockFlows,
                mockAgents,
                mockEntityTypes,
                mockEnvironments,
                mockIntents,
                mockSessionEntityTypes,
                mockSessions,
                mockTransitionRouteGroups,
                mockVersions,
                mockWebhooks));
    serviceHelper.start();
  }

  @AfterClass
  public static void stopServer() {
    serviceHelper.stop();
  }

  @Before
  public void setUp() throws IOException {
    serviceHelper.reset();
    channelProvider = serviceHelper.createChannelProvider();
    TransitionRouteGroupsSettings settings =
        TransitionRouteGroupsSettings.newBuilder()
            .setTransportChannelProvider(channelProvider)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = TransitionRouteGroupsClient.create(settings);
  }

  @After
  public void tearDown() throws Exception {
    client.close();
  }

  @Test
  @SuppressWarnings("all")
  public void listTransitionRouteGroupsTest() {
    String nextPageToken = "";
    TransitionRouteGroup transitionRouteGroupsElement = TransitionRouteGroup.newBuilder().build();
    List<TransitionRouteGroup> transitionRouteGroups = Arrays.asList(transitionRouteGroupsElement);
    ListTransitionRouteGroupsResponse expectedResponse =
        ListTransitionRouteGroupsResponse.newBuilder()
            .setNextPageToken(nextPageToken)
            .addAllTransitionRouteGroups(transitionRouteGroups)
            .build();
    mockTransitionRouteGroups.addResponse(expectedResponse);

    FlowName parent = FlowName.of("[PROJECT]", "[LOCATION]", "[AGENT]", "[FLOW]");

    ListTransitionRouteGroupsPagedResponse pagedListResponse =
        client.listTransitionRouteGroups(parent);

    List<TransitionRouteGroup> resources = Lists.newArrayList(pagedListResponse.iterateAll());
    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getTransitionRouteGroupsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockTransitionRouteGroups.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListTransitionRouteGroupsRequest actualRequest =
        (ListTransitionRouteGroupsRequest) actualRequests.get(0);

    Assert.assertEquals(parent, FlowName.parse(actualRequest.getParent()));
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void listTransitionRouteGroupsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockTransitionRouteGroups.addException(exception);

    try {
      FlowName parent = FlowName.of("[PROJECT]", "[LOCATION]", "[AGENT]", "[FLOW]");

      client.listTransitionRouteGroups(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void getTransitionRouteGroupTest() {
    TransitionRouteGroupName name2 =
        TransitionRouteGroupName.of(
            "[PROJECT]", "[LOCATION]", "[AGENT]", "[FLOW]", "[TRANSITION_ROUTE_GROUP]");
    String displayName = "displayName1615086568";
    TransitionRouteGroup expectedResponse =
        TransitionRouteGroup.newBuilder()
            .setName(name2.toString())
            .setDisplayName(displayName)
            .build();
    mockTransitionRouteGroups.addResponse(expectedResponse);

    TransitionRouteGroupName name =
        TransitionRouteGroupName.of(
            "[PROJECT]", "[LOCATION]", "[AGENT]", "[FLOW]", "[TRANSITION_ROUTE_GROUP]");

    TransitionRouteGroup actualResponse = client.getTransitionRouteGroup(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockTransitionRouteGroups.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetTransitionRouteGroupRequest actualRequest =
        (GetTransitionRouteGroupRequest) actualRequests.get(0);

    Assert.assertEquals(name, TransitionRouteGroupName.parse(actualRequest.getName()));
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void getTransitionRouteGroupExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockTransitionRouteGroups.addException(exception);

    try {
      TransitionRouteGroupName name =
          TransitionRouteGroupName.of(
              "[PROJECT]", "[LOCATION]", "[AGENT]", "[FLOW]", "[TRANSITION_ROUTE_GROUP]");

      client.getTransitionRouteGroup(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void createTransitionRouteGroupTest() {
    TransitionRouteGroupName name =
        TransitionRouteGroupName.of(
            "[PROJECT]", "[LOCATION]", "[AGENT]", "[FLOW]", "[TRANSITION_ROUTE_GROUP]");
    String displayName = "displayName1615086568";
    TransitionRouteGroup expectedResponse =
        TransitionRouteGroup.newBuilder()
            .setName(name.toString())
            .setDisplayName(displayName)
            .build();
    mockTransitionRouteGroups.addResponse(expectedResponse);

    FlowName parent = FlowName.of("[PROJECT]", "[LOCATION]", "[AGENT]", "[FLOW]");
    TransitionRouteGroup transitionRouteGroup = TransitionRouteGroup.newBuilder().build();

    TransitionRouteGroup actualResponse =
        client.createTransitionRouteGroup(parent, transitionRouteGroup);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockTransitionRouteGroups.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateTransitionRouteGroupRequest actualRequest =
        (CreateTransitionRouteGroupRequest) actualRequests.get(0);

    Assert.assertEquals(parent, FlowName.parse(actualRequest.getParent()));
    Assert.assertEquals(transitionRouteGroup, actualRequest.getTransitionRouteGroup());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void createTransitionRouteGroupExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockTransitionRouteGroups.addException(exception);

    try {
      FlowName parent = FlowName.of("[PROJECT]", "[LOCATION]", "[AGENT]", "[FLOW]");
      TransitionRouteGroup transitionRouteGroup = TransitionRouteGroup.newBuilder().build();

      client.createTransitionRouteGroup(parent, transitionRouteGroup);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void updateTransitionRouteGroupTest() {
    TransitionRouteGroupName name =
        TransitionRouteGroupName.of(
            "[PROJECT]", "[LOCATION]", "[AGENT]", "[FLOW]", "[TRANSITION_ROUTE_GROUP]");
    String displayName = "displayName1615086568";
    TransitionRouteGroup expectedResponse =
        TransitionRouteGroup.newBuilder()
            .setName(name.toString())
            .setDisplayName(displayName)
            .build();
    mockTransitionRouteGroups.addResponse(expectedResponse);

    TransitionRouteGroup transitionRouteGroup = TransitionRouteGroup.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    TransitionRouteGroup actualResponse =
        client.updateTransitionRouteGroup(transitionRouteGroup, updateMask);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockTransitionRouteGroups.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateTransitionRouteGroupRequest actualRequest =
        (UpdateTransitionRouteGroupRequest) actualRequests.get(0);

    Assert.assertEquals(transitionRouteGroup, actualRequest.getTransitionRouteGroup());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void updateTransitionRouteGroupExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockTransitionRouteGroups.addException(exception);

    try {
      TransitionRouteGroup transitionRouteGroup = TransitionRouteGroup.newBuilder().build();
      FieldMask updateMask = FieldMask.newBuilder().build();

      client.updateTransitionRouteGroup(transitionRouteGroup, updateMask);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void deleteTransitionRouteGroupTest() {
    Empty expectedResponse = Empty.newBuilder().build();
    mockTransitionRouteGroups.addResponse(expectedResponse);

    TransitionRouteGroupName name =
        TransitionRouteGroupName.of(
            "[PROJECT]", "[LOCATION]", "[AGENT]", "[FLOW]", "[TRANSITION_ROUTE_GROUP]");

    client.deleteTransitionRouteGroup(name);

    List<AbstractMessage> actualRequests = mockTransitionRouteGroups.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteTransitionRouteGroupRequest actualRequest =
        (DeleteTransitionRouteGroupRequest) actualRequests.get(0);

    Assert.assertEquals(name, TransitionRouteGroupName.parse(actualRequest.getName()));
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void deleteTransitionRouteGroupExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockTransitionRouteGroups.addException(exception);

    try {
      TransitionRouteGroupName name =
          TransitionRouteGroupName.of(
              "[PROJECT]", "[LOCATION]", "[AGENT]", "[FLOW]", "[TRANSITION_ROUTE_GROUP]");

      client.deleteTransitionRouteGroup(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }
}
