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

import static com.google.cloud.dialogflow.v2.SessionEntityTypesClient.ListSessionEntityTypesPagedResponse;

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
public class SessionEntityTypesClientTest {
  private static MockAgents mockAgents;
  private static MockContexts mockContexts;
  private static MockEntityTypes mockEntityTypes;
  private static MockIntents mockIntents;
  private static MockSessionEntityTypes mockSessionEntityTypes;
  private static MockSessions mockSessions;
  private static MockServiceHelper serviceHelper;
  private SessionEntityTypesClient client;
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
    SessionEntityTypesSettings settings =
        SessionEntityTypesSettings.newBuilder()
            .setTransportChannelProvider(channelProvider)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = SessionEntityTypesClient.create(settings);
  }

  @After
  public void tearDown() throws Exception {
    client.close();
  }

  @Test
  @SuppressWarnings("all")
  public void listSessionEntityTypesTest() {
    String nextPageToken = "";
    SessionEntityType sessionEntityTypesElement = SessionEntityType.newBuilder().build();
    List<SessionEntityType> sessionEntityTypes = Arrays.asList(sessionEntityTypesElement);
    ListSessionEntityTypesResponse expectedResponse =
        ListSessionEntityTypesResponse.newBuilder()
            .setNextPageToken(nextPageToken)
            .addAllSessionEntityTypes(sessionEntityTypes)
            .build();
    mockSessionEntityTypes.addResponse(expectedResponse);

    SessionName parent = SessionName.of("[PROJECT]", "[SESSION]");

    ListSessionEntityTypesPagedResponse pagedListResponse = client.listSessionEntityTypes(parent);

    List<SessionEntityType> resources = Lists.newArrayList(pagedListResponse.iterateAll());
    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getSessionEntityTypesList().get(0), resources.get(0));

    List<GeneratedMessageV3> actualRequests = mockSessionEntityTypes.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListSessionEntityTypesRequest actualRequest =
        (ListSessionEntityTypesRequest) actualRequests.get(0);

    Assert.assertEquals(parent, SessionName.parse(actualRequest.getParent()));
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void listSessionEntityTypesExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockSessionEntityTypes.addException(exception);

    try {
      SessionName parent = SessionName.of("[PROJECT]", "[SESSION]");

      client.listSessionEntityTypes(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void getSessionEntityTypeTest() {
    SessionEntityTypeName name2 =
        SessionEntityTypeName.of("[PROJECT]", "[SESSION]", "[ENTITY_TYPE]");
    SessionEntityType expectedResponse =
        SessionEntityType.newBuilder().setName(name2.toString()).build();
    mockSessionEntityTypes.addResponse(expectedResponse);

    SessionEntityTypeName name =
        SessionEntityTypeName.of("[PROJECT]", "[SESSION]", "[ENTITY_TYPE]");

    SessionEntityType actualResponse = client.getSessionEntityType(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<GeneratedMessageV3> actualRequests = mockSessionEntityTypes.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetSessionEntityTypeRequest actualRequest = (GetSessionEntityTypeRequest) actualRequests.get(0);

    Assert.assertEquals(name, SessionEntityTypeName.parse(actualRequest.getName()));
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void getSessionEntityTypeExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockSessionEntityTypes.addException(exception);

    try {
      SessionEntityTypeName name =
          SessionEntityTypeName.of("[PROJECT]", "[SESSION]", "[ENTITY_TYPE]");

      client.getSessionEntityType(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void createSessionEntityTypeTest() {
    SessionEntityTypeName name =
        SessionEntityTypeName.of("[PROJECT]", "[SESSION]", "[ENTITY_TYPE]");
    SessionEntityType expectedResponse =
        SessionEntityType.newBuilder().setName(name.toString()).build();
    mockSessionEntityTypes.addResponse(expectedResponse);

    SessionName parent = SessionName.of("[PROJECT]", "[SESSION]");
    SessionEntityType sessionEntityType = SessionEntityType.newBuilder().build();

    SessionEntityType actualResponse = client.createSessionEntityType(parent, sessionEntityType);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<GeneratedMessageV3> actualRequests = mockSessionEntityTypes.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateSessionEntityTypeRequest actualRequest =
        (CreateSessionEntityTypeRequest) actualRequests.get(0);

    Assert.assertEquals(parent, SessionName.parse(actualRequest.getParent()));
    Assert.assertEquals(sessionEntityType, actualRequest.getSessionEntityType());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void createSessionEntityTypeExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockSessionEntityTypes.addException(exception);

    try {
      SessionName parent = SessionName.of("[PROJECT]", "[SESSION]");
      SessionEntityType sessionEntityType = SessionEntityType.newBuilder().build();

      client.createSessionEntityType(parent, sessionEntityType);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void updateSessionEntityTypeTest() {
    SessionEntityTypeName name =
        SessionEntityTypeName.of("[PROJECT]", "[SESSION]", "[ENTITY_TYPE]");
    SessionEntityType expectedResponse =
        SessionEntityType.newBuilder().setName(name.toString()).build();
    mockSessionEntityTypes.addResponse(expectedResponse);

    SessionEntityType sessionEntityType = SessionEntityType.newBuilder().build();

    SessionEntityType actualResponse = client.updateSessionEntityType(sessionEntityType);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<GeneratedMessageV3> actualRequests = mockSessionEntityTypes.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateSessionEntityTypeRequest actualRequest =
        (UpdateSessionEntityTypeRequest) actualRequests.get(0);

    Assert.assertEquals(sessionEntityType, actualRequest.getSessionEntityType());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void updateSessionEntityTypeExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockSessionEntityTypes.addException(exception);

    try {
      SessionEntityType sessionEntityType = SessionEntityType.newBuilder().build();

      client.updateSessionEntityType(sessionEntityType);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void deleteSessionEntityTypeTest() {
    Empty expectedResponse = Empty.newBuilder().build();
    mockSessionEntityTypes.addResponse(expectedResponse);

    SessionEntityTypeName name =
        SessionEntityTypeName.of("[PROJECT]", "[SESSION]", "[ENTITY_TYPE]");

    client.deleteSessionEntityType(name);

    List<GeneratedMessageV3> actualRequests = mockSessionEntityTypes.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteSessionEntityTypeRequest actualRequest =
        (DeleteSessionEntityTypeRequest) actualRequests.get(0);

    Assert.assertEquals(name, SessionEntityTypeName.parse(actualRequest.getName()));
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void deleteSessionEntityTypeExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockSessionEntityTypes.addException(exception);

    try {
      SessionEntityTypeName name =
          SessionEntityTypeName.of("[PROJECT]", "[SESSION]", "[ENTITY_TYPE]");

      client.deleteSessionEntityType(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }
}
