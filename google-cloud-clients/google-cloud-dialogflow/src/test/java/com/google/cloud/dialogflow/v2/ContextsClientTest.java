/*
 * Copyright 2019 Google LLC
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
package com.google.cloud.dialogflow.v2;

import static com.google.cloud.dialogflow.v2.ContextsClient.ListContextsPagedResponse;

import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.grpc.GaxGrpcProperties;
import com.google.api.gax.grpc.testing.LocalChannelProvider;
import com.google.api.gax.grpc.testing.MockGrpcService;
import com.google.api.gax.grpc.testing.MockServiceHelper;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.common.collect.Lists;
import com.google.protobuf.Empty;
import com.google.protobuf.GeneratedMessageV3;
import io.grpc.Status;
import io.grpc.StatusRuntimeException;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

@javax.annotation.Generated("by GAPIC")
public class ContextsClientTest {
  private static MockAgents mockAgents;
  private static MockContexts mockContexts;
  private static MockEntityTypes mockEntityTypes;
  private static MockIntents mockIntents;
  private static MockSessionEntityTypes mockSessionEntityTypes;
  private static MockSessions mockSessions;
  private static MockServiceHelper serviceHelper;
  private ContextsClient client;
  private LocalChannelProvider channelProvider;

  @BeforeClass
  public static void startStaticServer() {
    mockAgents = new MockAgents();
    mockContexts = new MockContexts();
    mockEntityTypes = new MockEntityTypes();
    mockIntents = new MockIntents();
    mockSessionEntityTypes = new MockSessionEntityTypes();
    mockSessions = new MockSessions();
    serviceHelper =
        new MockServiceHelper(
            "in-process-1",
            Arrays.<MockGrpcService>asList(
                mockAgents,
                mockContexts,
                mockEntityTypes,
                mockIntents,
                mockSessionEntityTypes,
                mockSessions));
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
    ContextsSettings settings =
        ContextsSettings.newBuilder()
            .setTransportChannelProvider(channelProvider)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = ContextsClient.create(settings);
  }

  @After
  public void tearDown() throws Exception {
    client.close();
  }

  @Test
  @SuppressWarnings("all")
  public void listContextsTest() {
    String nextPageToken = "";
    Context contextsElement = Context.newBuilder().build();
    List<Context> contexts = Arrays.asList(contextsElement);
    ListContextsResponse expectedResponse =
        ListContextsResponse.newBuilder()
            .setNextPageToken(nextPageToken)
            .addAllContexts(contexts)
            .build();
    mockContexts.addResponse(expectedResponse);

    SessionName parent = SessionName.of("[PROJECT]", "[SESSION]");

    ListContextsPagedResponse pagedListResponse = client.listContexts(parent);

    List<Context> resources = Lists.newArrayList(pagedListResponse.iterateAll());
    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getContextsList().get(0), resources.get(0));

    List<GeneratedMessageV3> actualRequests = mockContexts.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListContextsRequest actualRequest = (ListContextsRequest) actualRequests.get(0);

    Assert.assertEquals(parent, SessionName.parse(actualRequest.getParent()));
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void listContextsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockContexts.addException(exception);

    try {
      SessionName parent = SessionName.of("[PROJECT]", "[SESSION]");

      client.listContexts(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void getContextTest() {
    ContextName name2 = ContextName.of("[PROJECT]", "[SESSION]", "[CONTEXT]");
    int lifespanCount = 1178775510;
    Context expectedResponse =
        Context.newBuilder().setName(name2.toString()).setLifespanCount(lifespanCount).build();
    mockContexts.addResponse(expectedResponse);

    ContextName name = ContextName.of("[PROJECT]", "[SESSION]", "[CONTEXT]");

    Context actualResponse = client.getContext(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<GeneratedMessageV3> actualRequests = mockContexts.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetContextRequest actualRequest = (GetContextRequest) actualRequests.get(0);

    Assert.assertEquals(name, ContextName.parse(actualRequest.getName()));
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void getContextExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockContexts.addException(exception);

    try {
      ContextName name = ContextName.of("[PROJECT]", "[SESSION]", "[CONTEXT]");

      client.getContext(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void createContextTest() {
    ContextName name = ContextName.of("[PROJECT]", "[SESSION]", "[CONTEXT]");
    int lifespanCount = 1178775510;
    Context expectedResponse =
        Context.newBuilder().setName(name.toString()).setLifespanCount(lifespanCount).build();
    mockContexts.addResponse(expectedResponse);

    SessionName parent = SessionName.of("[PROJECT]", "[SESSION]");
    Context context = Context.newBuilder().build();

    Context actualResponse = client.createContext(parent, context);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<GeneratedMessageV3> actualRequests = mockContexts.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateContextRequest actualRequest = (CreateContextRequest) actualRequests.get(0);

    Assert.assertEquals(parent, SessionName.parse(actualRequest.getParent()));
    Assert.assertEquals(context, actualRequest.getContext());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void createContextExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockContexts.addException(exception);

    try {
      SessionName parent = SessionName.of("[PROJECT]", "[SESSION]");
      Context context = Context.newBuilder().build();

      client.createContext(parent, context);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void updateContextTest() {
    ContextName name = ContextName.of("[PROJECT]", "[SESSION]", "[CONTEXT]");
    int lifespanCount = 1178775510;
    Context expectedResponse =
        Context.newBuilder().setName(name.toString()).setLifespanCount(lifespanCount).build();
    mockContexts.addResponse(expectedResponse);

    Context context = Context.newBuilder().build();

    Context actualResponse = client.updateContext(context);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<GeneratedMessageV3> actualRequests = mockContexts.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateContextRequest actualRequest = (UpdateContextRequest) actualRequests.get(0);

    Assert.assertEquals(context, actualRequest.getContext());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void updateContextExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockContexts.addException(exception);

    try {
      Context context = Context.newBuilder().build();

      client.updateContext(context);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void deleteContextTest() {
    Empty expectedResponse = Empty.newBuilder().build();
    mockContexts.addResponse(expectedResponse);

    ContextName name = ContextName.of("[PROJECT]", "[SESSION]", "[CONTEXT]");

    client.deleteContext(name);

    List<GeneratedMessageV3> actualRequests = mockContexts.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteContextRequest actualRequest = (DeleteContextRequest) actualRequests.get(0);

    Assert.assertEquals(name, ContextName.parse(actualRequest.getName()));
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void deleteContextExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockContexts.addException(exception);

    try {
      ContextName name = ContextName.of("[PROJECT]", "[SESSION]", "[CONTEXT]");

      client.deleteContext(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void deleteAllContextsTest() {
    Empty expectedResponse = Empty.newBuilder().build();
    mockContexts.addResponse(expectedResponse);

    SessionName parent = SessionName.of("[PROJECT]", "[SESSION]");

    client.deleteAllContexts(parent);

    List<GeneratedMessageV3> actualRequests = mockContexts.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteAllContextsRequest actualRequest = (DeleteAllContextsRequest) actualRequests.get(0);

    Assert.assertEquals(parent, SessionName.parse(actualRequest.getParent()));
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void deleteAllContextsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockContexts.addException(exception);

    try {
      SessionName parent = SessionName.of("[PROJECT]", "[SESSION]");

      client.deleteAllContexts(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }
}
