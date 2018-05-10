/*
 * Copyright 2018 Google LLC
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

import static com.google.cloud.dialogflow.v2.IntentsClient.ListIntentsPagedResponse;

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
import com.google.protobuf.Any;
import com.google.protobuf.Empty;
import com.google.protobuf.FieldMask;
import com.google.protobuf.GeneratedMessageV3;
import io.grpc.Status;
import io.grpc.StatusRuntimeException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutionException;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

@javax.annotation.Generated("by GAPIC")
public class IntentsClientTest {
  private static MockAgents mockAgents;
  private static MockContexts mockContexts;
  private static MockEntityTypes mockEntityTypes;
  private static MockIntents mockIntents;
  private static MockSessionEntityTypes mockSessionEntityTypes;
  private static MockSessions mockSessions;
  private static MockServiceHelper serviceHelper;
  private IntentsClient client;
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
    IntentsSettings settings =
        IntentsSettings.newBuilder()
            .setTransportChannelProvider(channelProvider)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = IntentsClient.create(settings);
  }

  @After
  public void tearDown() throws Exception {
    client.close();
  }

  @Test
  @SuppressWarnings("all")
  public void listIntentsTest() {
    String nextPageToken = "";
    Intent intentsElement = Intent.newBuilder().build();
    List<Intent> intents = Arrays.asList(intentsElement);
    ListIntentsResponse expectedResponse =
        ListIntentsResponse.newBuilder()
            .setNextPageToken(nextPageToken)
            .addAllIntents(intents)
            .build();
    mockIntents.addResponse(expectedResponse);

    ProjectAgentName parent = ProjectAgentName.of("[PROJECT]");

    ListIntentsPagedResponse pagedListResponse = client.listIntents(parent);

    List<Intent> resources = Lists.newArrayList(pagedListResponse.iterateAll());
    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getIntentsList().get(0), resources.get(0));

    List<GeneratedMessageV3> actualRequests = mockIntents.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListIntentsRequest actualRequest = (ListIntentsRequest) actualRequests.get(0);

    Assert.assertEquals(parent, ProjectAgentName.parse(actualRequest.getParent()));
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void listIntentsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockIntents.addException(exception);

    try {
      ProjectAgentName parent = ProjectAgentName.of("[PROJECT]");

      client.listIntents(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void listIntentsTest2() {
    String nextPageToken = "";
    Intent intentsElement = Intent.newBuilder().build();
    List<Intent> intents = Arrays.asList(intentsElement);
    ListIntentsResponse expectedResponse =
        ListIntentsResponse.newBuilder()
            .setNextPageToken(nextPageToken)
            .addAllIntents(intents)
            .build();
    mockIntents.addResponse(expectedResponse);

    ProjectAgentName parent = ProjectAgentName.of("[PROJECT]");
    String languageCode = "languageCode-412800396";

    ListIntentsPagedResponse pagedListResponse = client.listIntents(parent, languageCode);

    List<Intent> resources = Lists.newArrayList(pagedListResponse.iterateAll());
    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getIntentsList().get(0), resources.get(0));

    List<GeneratedMessageV3> actualRequests = mockIntents.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListIntentsRequest actualRequest = (ListIntentsRequest) actualRequests.get(0);

    Assert.assertEquals(parent, ProjectAgentName.parse(actualRequest.getParent()));
    Assert.assertEquals(languageCode, actualRequest.getLanguageCode());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void listIntentsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockIntents.addException(exception);

    try {
      ProjectAgentName parent = ProjectAgentName.of("[PROJECT]");
      String languageCode = "languageCode-412800396";

      client.listIntents(parent, languageCode);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void getIntentTest() {
    IntentName name2 = IntentName.of("[PROJECT]", "[INTENT]");
    String displayName = "displayName1615086568";
    int priority = 1165461084;
    boolean isFallback = false;
    boolean mlDisabled = true;
    String action = "action-1422950858";
    boolean resetContexts = true;
    String rootFollowupIntentName = "rootFollowupIntentName402253784";
    String parentFollowupIntentName = "parentFollowupIntentName-1131901680";
    Intent expectedResponse =
        Intent.newBuilder()
            .setName(name2.toString())
            .setDisplayName(displayName)
            .setPriority(priority)
            .setIsFallback(isFallback)
            .setMlDisabled(mlDisabled)
            .setAction(action)
            .setResetContexts(resetContexts)
            .setRootFollowupIntentName(rootFollowupIntentName)
            .setParentFollowupIntentName(parentFollowupIntentName)
            .build();
    mockIntents.addResponse(expectedResponse);

    IntentName name = IntentName.of("[PROJECT]", "[INTENT]");

    Intent actualResponse = client.getIntent(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<GeneratedMessageV3> actualRequests = mockIntents.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetIntentRequest actualRequest = (GetIntentRequest) actualRequests.get(0);

    Assert.assertEquals(name, IntentName.parse(actualRequest.getName()));
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void getIntentExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockIntents.addException(exception);

    try {
      IntentName name = IntentName.of("[PROJECT]", "[INTENT]");

      client.getIntent(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void getIntentTest2() {
    IntentName name2 = IntentName.of("[PROJECT]", "[INTENT]");
    String displayName = "displayName1615086568";
    int priority = 1165461084;
    boolean isFallback = false;
    boolean mlDisabled = true;
    String action = "action-1422950858";
    boolean resetContexts = true;
    String rootFollowupIntentName = "rootFollowupIntentName402253784";
    String parentFollowupIntentName = "parentFollowupIntentName-1131901680";
    Intent expectedResponse =
        Intent.newBuilder()
            .setName(name2.toString())
            .setDisplayName(displayName)
            .setPriority(priority)
            .setIsFallback(isFallback)
            .setMlDisabled(mlDisabled)
            .setAction(action)
            .setResetContexts(resetContexts)
            .setRootFollowupIntentName(rootFollowupIntentName)
            .setParentFollowupIntentName(parentFollowupIntentName)
            .build();
    mockIntents.addResponse(expectedResponse);

    IntentName name = IntentName.of("[PROJECT]", "[INTENT]");
    String languageCode = "languageCode-412800396";

    Intent actualResponse = client.getIntent(name, languageCode);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<GeneratedMessageV3> actualRequests = mockIntents.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetIntentRequest actualRequest = (GetIntentRequest) actualRequests.get(0);

    Assert.assertEquals(name, IntentName.parse(actualRequest.getName()));
    Assert.assertEquals(languageCode, actualRequest.getLanguageCode());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void getIntentExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockIntents.addException(exception);

    try {
      IntentName name = IntentName.of("[PROJECT]", "[INTENT]");
      String languageCode = "languageCode-412800396";

      client.getIntent(name, languageCode);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void createIntentTest() {
    IntentName name = IntentName.of("[PROJECT]", "[INTENT]");
    String displayName = "displayName1615086568";
    int priority = 1165461084;
    boolean isFallback = false;
    boolean mlDisabled = true;
    String action = "action-1422950858";
    boolean resetContexts = true;
    String rootFollowupIntentName = "rootFollowupIntentName402253784";
    String parentFollowupIntentName = "parentFollowupIntentName-1131901680";
    Intent expectedResponse =
        Intent.newBuilder()
            .setName(name.toString())
            .setDisplayName(displayName)
            .setPriority(priority)
            .setIsFallback(isFallback)
            .setMlDisabled(mlDisabled)
            .setAction(action)
            .setResetContexts(resetContexts)
            .setRootFollowupIntentName(rootFollowupIntentName)
            .setParentFollowupIntentName(parentFollowupIntentName)
            .build();
    mockIntents.addResponse(expectedResponse);

    ProjectAgentName parent = ProjectAgentName.of("[PROJECT]");
    Intent intent = Intent.newBuilder().build();

    Intent actualResponse = client.createIntent(parent, intent);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<GeneratedMessageV3> actualRequests = mockIntents.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateIntentRequest actualRequest = (CreateIntentRequest) actualRequests.get(0);

    Assert.assertEquals(parent, ProjectAgentName.parse(actualRequest.getParent()));
    Assert.assertEquals(intent, actualRequest.getIntent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void createIntentExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockIntents.addException(exception);

    try {
      ProjectAgentName parent = ProjectAgentName.of("[PROJECT]");
      Intent intent = Intent.newBuilder().build();

      client.createIntent(parent, intent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void createIntentTest2() {
    IntentName name = IntentName.of("[PROJECT]", "[INTENT]");
    String displayName = "displayName1615086568";
    int priority = 1165461084;
    boolean isFallback = false;
    boolean mlDisabled = true;
    String action = "action-1422950858";
    boolean resetContexts = true;
    String rootFollowupIntentName = "rootFollowupIntentName402253784";
    String parentFollowupIntentName = "parentFollowupIntentName-1131901680";
    Intent expectedResponse =
        Intent.newBuilder()
            .setName(name.toString())
            .setDisplayName(displayName)
            .setPriority(priority)
            .setIsFallback(isFallback)
            .setMlDisabled(mlDisabled)
            .setAction(action)
            .setResetContexts(resetContexts)
            .setRootFollowupIntentName(rootFollowupIntentName)
            .setParentFollowupIntentName(parentFollowupIntentName)
            .build();
    mockIntents.addResponse(expectedResponse);

    ProjectAgentName parent = ProjectAgentName.of("[PROJECT]");
    Intent intent = Intent.newBuilder().build();
    String languageCode = "languageCode-412800396";

    Intent actualResponse = client.createIntent(parent, intent, languageCode);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<GeneratedMessageV3> actualRequests = mockIntents.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateIntentRequest actualRequest = (CreateIntentRequest) actualRequests.get(0);

    Assert.assertEquals(parent, ProjectAgentName.parse(actualRequest.getParent()));
    Assert.assertEquals(intent, actualRequest.getIntent());
    Assert.assertEquals(languageCode, actualRequest.getLanguageCode());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void createIntentExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockIntents.addException(exception);

    try {
      ProjectAgentName parent = ProjectAgentName.of("[PROJECT]");
      Intent intent = Intent.newBuilder().build();
      String languageCode = "languageCode-412800396";

      client.createIntent(parent, intent, languageCode);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void updateIntentTest() {
    IntentName name = IntentName.of("[PROJECT]", "[INTENT]");
    String displayName = "displayName1615086568";
    int priority = 1165461084;
    boolean isFallback = false;
    boolean mlDisabled = true;
    String action = "action-1422950858";
    boolean resetContexts = true;
    String rootFollowupIntentName = "rootFollowupIntentName402253784";
    String parentFollowupIntentName = "parentFollowupIntentName-1131901680";
    Intent expectedResponse =
        Intent.newBuilder()
            .setName(name.toString())
            .setDisplayName(displayName)
            .setPriority(priority)
            .setIsFallback(isFallback)
            .setMlDisabled(mlDisabled)
            .setAction(action)
            .setResetContexts(resetContexts)
            .setRootFollowupIntentName(rootFollowupIntentName)
            .setParentFollowupIntentName(parentFollowupIntentName)
            .build();
    mockIntents.addResponse(expectedResponse);

    Intent intent = Intent.newBuilder().build();
    String languageCode = "languageCode-412800396";

    Intent actualResponse = client.updateIntent(intent, languageCode);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<GeneratedMessageV3> actualRequests = mockIntents.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateIntentRequest actualRequest = (UpdateIntentRequest) actualRequests.get(0);

    Assert.assertEquals(intent, actualRequest.getIntent());
    Assert.assertEquals(languageCode, actualRequest.getLanguageCode());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void updateIntentExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockIntents.addException(exception);

    try {
      Intent intent = Intent.newBuilder().build();
      String languageCode = "languageCode-412800396";

      client.updateIntent(intent, languageCode);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void updateIntentTest2() {
    IntentName name = IntentName.of("[PROJECT]", "[INTENT]");
    String displayName = "displayName1615086568";
    int priority = 1165461084;
    boolean isFallback = false;
    boolean mlDisabled = true;
    String action = "action-1422950858";
    boolean resetContexts = true;
    String rootFollowupIntentName = "rootFollowupIntentName402253784";
    String parentFollowupIntentName = "parentFollowupIntentName-1131901680";
    Intent expectedResponse =
        Intent.newBuilder()
            .setName(name.toString())
            .setDisplayName(displayName)
            .setPriority(priority)
            .setIsFallback(isFallback)
            .setMlDisabled(mlDisabled)
            .setAction(action)
            .setResetContexts(resetContexts)
            .setRootFollowupIntentName(rootFollowupIntentName)
            .setParentFollowupIntentName(parentFollowupIntentName)
            .build();
    mockIntents.addResponse(expectedResponse);

    Intent intent = Intent.newBuilder().build();
    String languageCode = "languageCode-412800396";
    FieldMask updateMask = FieldMask.newBuilder().build();

    Intent actualResponse = client.updateIntent(intent, languageCode, updateMask);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<GeneratedMessageV3> actualRequests = mockIntents.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateIntentRequest actualRequest = (UpdateIntentRequest) actualRequests.get(0);

    Assert.assertEquals(intent, actualRequest.getIntent());
    Assert.assertEquals(languageCode, actualRequest.getLanguageCode());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void updateIntentExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockIntents.addException(exception);

    try {
      Intent intent = Intent.newBuilder().build();
      String languageCode = "languageCode-412800396";
      FieldMask updateMask = FieldMask.newBuilder().build();

      client.updateIntent(intent, languageCode, updateMask);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void deleteIntentTest() {
    Empty expectedResponse = Empty.newBuilder().build();
    mockIntents.addResponse(expectedResponse);

    IntentName name = IntentName.of("[PROJECT]", "[INTENT]");

    client.deleteIntent(name);

    List<GeneratedMessageV3> actualRequests = mockIntents.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteIntentRequest actualRequest = (DeleteIntentRequest) actualRequests.get(0);

    Assert.assertEquals(name, IntentName.parse(actualRequest.getName()));
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void deleteIntentExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockIntents.addException(exception);

    try {
      IntentName name = IntentName.of("[PROJECT]", "[INTENT]");

      client.deleteIntent(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void batchDeleteIntentsTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("batchDeleteIntentsTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockIntents.addResponse(resultOperation);

    ProjectAgentName parent = ProjectAgentName.of("[PROJECT]");
    List<Intent> intents = new ArrayList<>();

    Empty actualResponse = client.batchDeleteIntentsAsync(parent, intents).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<GeneratedMessageV3> actualRequests = mockIntents.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    BatchDeleteIntentsRequest actualRequest = (BatchDeleteIntentsRequest) actualRequests.get(0);

    Assert.assertEquals(parent, ProjectAgentName.parse(actualRequest.getParent()));
    Assert.assertEquals(intents, actualRequest.getIntentsList());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void batchDeleteIntentsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockIntents.addException(exception);

    try {
      ProjectAgentName parent = ProjectAgentName.of("[PROJECT]");
      List<Intent> intents = new ArrayList<>();

      client.batchDeleteIntentsAsync(parent, intents).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = (InvalidArgumentException) e.getCause();
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }
}
