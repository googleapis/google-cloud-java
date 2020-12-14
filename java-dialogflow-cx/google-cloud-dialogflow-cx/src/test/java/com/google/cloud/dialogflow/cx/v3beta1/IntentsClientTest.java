/*
 * Copyright 2020 Google LLC
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

package com.google.cloud.dialogflow.cx.v3beta1;

import static com.google.cloud.dialogflow.cx.v3beta1.IntentsClient.ListIntentsPagedResponse;

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
import io.grpc.StatusRuntimeException;
import java.io.IOException;
import java.util.ArrayList;
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
public class IntentsClientTest {
  private static MockServiceHelper mockServiceHelper;
  private static MockIntents mockIntents;
  private IntentsClient client;
  private LocalChannelProvider channelProvider;

  @BeforeClass
  public static void startStaticServer() {
    mockIntents = new MockIntents();
    mockServiceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(), Arrays.<MockGrpcService>asList(mockIntents));
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
  public void listIntentsTest() throws Exception {
    Intent responsesElement = Intent.newBuilder().build();
    ListIntentsResponse expectedResponse =
        ListIntentsResponse.newBuilder()
            .setNextPageToken("")
            .addAllIntents(Arrays.asList(responsesElement))
            .build();
    mockIntents.addResponse(expectedResponse);

    AgentName parent = AgentName.of("[PROJECT]", "[LOCATION]", "[AGENT]");

    ListIntentsPagedResponse pagedListResponse = client.listIntents(parent);

    List<Intent> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getIntentsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockIntents.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListIntentsRequest actualRequest = ((ListIntentsRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listIntentsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockIntents.addException(exception);

    try {
      AgentName parent = AgentName.of("[PROJECT]", "[LOCATION]", "[AGENT]");
      client.listIntents(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listIntentsTest2() throws Exception {
    Intent responsesElement = Intent.newBuilder().build();
    ListIntentsResponse expectedResponse =
        ListIntentsResponse.newBuilder()
            .setNextPageToken("")
            .addAllIntents(Arrays.asList(responsesElement))
            .build();
    mockIntents.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListIntentsPagedResponse pagedListResponse = client.listIntents(parent);

    List<Intent> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getIntentsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockIntents.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListIntentsRequest actualRequest = ((ListIntentsRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listIntentsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockIntents.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listIntents(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getIntentTest() throws Exception {
    Intent expectedResponse =
        Intent.newBuilder()
            .setName(IntentName.of("[PROJECT]", "[LOCATION]", "[AGENT]", "[INTENT]").toString())
            .setDisplayName("displayName1714148973")
            .addAllTrainingPhrases(new ArrayList<Intent.TrainingPhrase>())
            .addAllParameters(new ArrayList<Intent.Parameter>())
            .setPriority(-1165461084)
            .setIsFallback(true)
            .putAllLabels(new HashMap<String, String>())
            .setDescription("description-1724546052")
            .build();
    mockIntents.addResponse(expectedResponse);

    IntentName name = IntentName.of("[PROJECT]", "[LOCATION]", "[AGENT]", "[INTENT]");

    Intent actualResponse = client.getIntent(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockIntents.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetIntentRequest actualRequest = ((GetIntentRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getIntentExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockIntents.addException(exception);

    try {
      IntentName name = IntentName.of("[PROJECT]", "[LOCATION]", "[AGENT]", "[INTENT]");
      client.getIntent(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getIntentTest2() throws Exception {
    Intent expectedResponse =
        Intent.newBuilder()
            .setName(IntentName.of("[PROJECT]", "[LOCATION]", "[AGENT]", "[INTENT]").toString())
            .setDisplayName("displayName1714148973")
            .addAllTrainingPhrases(new ArrayList<Intent.TrainingPhrase>())
            .addAllParameters(new ArrayList<Intent.Parameter>())
            .setPriority(-1165461084)
            .setIsFallback(true)
            .putAllLabels(new HashMap<String, String>())
            .setDescription("description-1724546052")
            .build();
    mockIntents.addResponse(expectedResponse);

    String name = "name3373707";

    Intent actualResponse = client.getIntent(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockIntents.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetIntentRequest actualRequest = ((GetIntentRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getIntentExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockIntents.addException(exception);

    try {
      String name = "name3373707";
      client.getIntent(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createIntentTest() throws Exception {
    Intent expectedResponse =
        Intent.newBuilder()
            .setName(IntentName.of("[PROJECT]", "[LOCATION]", "[AGENT]", "[INTENT]").toString())
            .setDisplayName("displayName1714148973")
            .addAllTrainingPhrases(new ArrayList<Intent.TrainingPhrase>())
            .addAllParameters(new ArrayList<Intent.Parameter>())
            .setPriority(-1165461084)
            .setIsFallback(true)
            .putAllLabels(new HashMap<String, String>())
            .setDescription("description-1724546052")
            .build();
    mockIntents.addResponse(expectedResponse);

    AgentName parent = AgentName.of("[PROJECT]", "[LOCATION]", "[AGENT]");
    Intent intent = Intent.newBuilder().build();

    Intent actualResponse = client.createIntent(parent, intent);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockIntents.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateIntentRequest actualRequest = ((CreateIntentRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(intent, actualRequest.getIntent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createIntentExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockIntents.addException(exception);

    try {
      AgentName parent = AgentName.of("[PROJECT]", "[LOCATION]", "[AGENT]");
      Intent intent = Intent.newBuilder().build();
      client.createIntent(parent, intent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createIntentTest2() throws Exception {
    Intent expectedResponse =
        Intent.newBuilder()
            .setName(IntentName.of("[PROJECT]", "[LOCATION]", "[AGENT]", "[INTENT]").toString())
            .setDisplayName("displayName1714148973")
            .addAllTrainingPhrases(new ArrayList<Intent.TrainingPhrase>())
            .addAllParameters(new ArrayList<Intent.Parameter>())
            .setPriority(-1165461084)
            .setIsFallback(true)
            .putAllLabels(new HashMap<String, String>())
            .setDescription("description-1724546052")
            .build();
    mockIntents.addResponse(expectedResponse);

    String parent = "parent-995424086";
    Intent intent = Intent.newBuilder().build();

    Intent actualResponse = client.createIntent(parent, intent);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockIntents.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateIntentRequest actualRequest = ((CreateIntentRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(intent, actualRequest.getIntent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createIntentExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockIntents.addException(exception);

    try {
      String parent = "parent-995424086";
      Intent intent = Intent.newBuilder().build();
      client.createIntent(parent, intent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updateIntentTest() throws Exception {
    Intent expectedResponse =
        Intent.newBuilder()
            .setName(IntentName.of("[PROJECT]", "[LOCATION]", "[AGENT]", "[INTENT]").toString())
            .setDisplayName("displayName1714148973")
            .addAllTrainingPhrases(new ArrayList<Intent.TrainingPhrase>())
            .addAllParameters(new ArrayList<Intent.Parameter>())
            .setPriority(-1165461084)
            .setIsFallback(true)
            .putAllLabels(new HashMap<String, String>())
            .setDescription("description-1724546052")
            .build();
    mockIntents.addResponse(expectedResponse);

    Intent intent = Intent.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    Intent actualResponse = client.updateIntent(intent, updateMask);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockIntents.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateIntentRequest actualRequest = ((UpdateIntentRequest) actualRequests.get(0));

    Assert.assertEquals(intent, actualRequest.getIntent());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateIntentExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockIntents.addException(exception);

    try {
      Intent intent = Intent.newBuilder().build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateIntent(intent, updateMask);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteIntentTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockIntents.addResponse(expectedResponse);

    IntentName name = IntentName.of("[PROJECT]", "[LOCATION]", "[AGENT]", "[INTENT]");

    client.deleteIntent(name);

    List<AbstractMessage> actualRequests = mockIntents.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteIntentRequest actualRequest = ((DeleteIntentRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteIntentExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockIntents.addException(exception);

    try {
      IntentName name = IntentName.of("[PROJECT]", "[LOCATION]", "[AGENT]", "[INTENT]");
      client.deleteIntent(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteIntentTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockIntents.addResponse(expectedResponse);

    String name = "name3373707";

    client.deleteIntent(name);

    List<AbstractMessage> actualRequests = mockIntents.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteIntentRequest actualRequest = ((DeleteIntentRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteIntentExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockIntents.addException(exception);

    try {
      String name = "name3373707";
      client.deleteIntent(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
