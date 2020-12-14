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

import static com.google.cloud.dialogflow.cx.v3beta1.WebhooksClient.ListWebhooksPagedResponse;

import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.grpc.GaxGrpcProperties;
import com.google.api.gax.grpc.testing.LocalChannelProvider;
import com.google.api.gax.grpc.testing.MockGrpcService;
import com.google.api.gax.grpc.testing.MockServiceHelper;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.common.collect.Lists;
import com.google.protobuf.AbstractMessage;
import com.google.protobuf.Duration;
import com.google.protobuf.Empty;
import com.google.protobuf.FieldMask;
import io.grpc.StatusRuntimeException;
import java.io.IOException;
import java.util.Arrays;
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
public class WebhooksClientTest {
  private static MockWebhooks mockWebhooks;
  private static MockServiceHelper mockServiceHelper;
  private WebhooksClient client;
  private LocalChannelProvider channelProvider;

  @BeforeClass
  public static void startStaticServer() {
    mockWebhooks = new MockWebhooks();
    mockServiceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(), Arrays.<MockGrpcService>asList(mockWebhooks));
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
    WebhooksSettings settings =
        WebhooksSettings.newBuilder()
            .setTransportChannelProvider(channelProvider)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = WebhooksClient.create(settings);
  }

  @After
  public void tearDown() throws Exception {
    client.close();
  }

  @Test
  public void listWebhooksTest() throws Exception {
    Webhook responsesElement = Webhook.newBuilder().build();
    ListWebhooksResponse expectedResponse =
        ListWebhooksResponse.newBuilder()
            .setNextPageToken("")
            .addAllWebhooks(Arrays.asList(responsesElement))
            .build();
    mockWebhooks.addResponse(expectedResponse);

    AgentName parent = AgentName.of("[PROJECT]", "[LOCATION]", "[AGENT]");

    ListWebhooksPagedResponse pagedListResponse = client.listWebhooks(parent);

    List<Webhook> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getWebhooksList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockWebhooks.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListWebhooksRequest actualRequest = ((ListWebhooksRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listWebhooksExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockWebhooks.addException(exception);

    try {
      AgentName parent = AgentName.of("[PROJECT]", "[LOCATION]", "[AGENT]");
      client.listWebhooks(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listWebhooksTest2() throws Exception {
    Webhook responsesElement = Webhook.newBuilder().build();
    ListWebhooksResponse expectedResponse =
        ListWebhooksResponse.newBuilder()
            .setNextPageToken("")
            .addAllWebhooks(Arrays.asList(responsesElement))
            .build();
    mockWebhooks.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListWebhooksPagedResponse pagedListResponse = client.listWebhooks(parent);

    List<Webhook> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getWebhooksList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockWebhooks.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListWebhooksRequest actualRequest = ((ListWebhooksRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listWebhooksExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockWebhooks.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listWebhooks(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getWebhookTest() throws Exception {
    Webhook expectedResponse =
        Webhook.newBuilder()
            .setName(WebhookName.of("[PROJECT]", "[LOCATION]", "[AGENT]", "[WEBHOOK]").toString())
            .setDisplayName("displayName1714148973")
            .setTimeout(Duration.newBuilder().build())
            .setDisabled(true)
            .build();
    mockWebhooks.addResponse(expectedResponse);

    WebhookName name = WebhookName.of("[PROJECT]", "[LOCATION]", "[AGENT]", "[WEBHOOK]");

    Webhook actualResponse = client.getWebhook(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockWebhooks.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetWebhookRequest actualRequest = ((GetWebhookRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getWebhookExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockWebhooks.addException(exception);

    try {
      WebhookName name = WebhookName.of("[PROJECT]", "[LOCATION]", "[AGENT]", "[WEBHOOK]");
      client.getWebhook(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getWebhookTest2() throws Exception {
    Webhook expectedResponse =
        Webhook.newBuilder()
            .setName(WebhookName.of("[PROJECT]", "[LOCATION]", "[AGENT]", "[WEBHOOK]").toString())
            .setDisplayName("displayName1714148973")
            .setTimeout(Duration.newBuilder().build())
            .setDisabled(true)
            .build();
    mockWebhooks.addResponse(expectedResponse);

    String name = "name3373707";

    Webhook actualResponse = client.getWebhook(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockWebhooks.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetWebhookRequest actualRequest = ((GetWebhookRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getWebhookExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockWebhooks.addException(exception);

    try {
      String name = "name3373707";
      client.getWebhook(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createWebhookTest() throws Exception {
    Webhook expectedResponse =
        Webhook.newBuilder()
            .setName(WebhookName.of("[PROJECT]", "[LOCATION]", "[AGENT]", "[WEBHOOK]").toString())
            .setDisplayName("displayName1714148973")
            .setTimeout(Duration.newBuilder().build())
            .setDisabled(true)
            .build();
    mockWebhooks.addResponse(expectedResponse);

    AgentName parent = AgentName.of("[PROJECT]", "[LOCATION]", "[AGENT]");
    Webhook webhook = Webhook.newBuilder().build();

    Webhook actualResponse = client.createWebhook(parent, webhook);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockWebhooks.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateWebhookRequest actualRequest = ((CreateWebhookRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(webhook, actualRequest.getWebhook());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createWebhookExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockWebhooks.addException(exception);

    try {
      AgentName parent = AgentName.of("[PROJECT]", "[LOCATION]", "[AGENT]");
      Webhook webhook = Webhook.newBuilder().build();
      client.createWebhook(parent, webhook);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createWebhookTest2() throws Exception {
    Webhook expectedResponse =
        Webhook.newBuilder()
            .setName(WebhookName.of("[PROJECT]", "[LOCATION]", "[AGENT]", "[WEBHOOK]").toString())
            .setDisplayName("displayName1714148973")
            .setTimeout(Duration.newBuilder().build())
            .setDisabled(true)
            .build();
    mockWebhooks.addResponse(expectedResponse);

    String parent = "parent-995424086";
    Webhook webhook = Webhook.newBuilder().build();

    Webhook actualResponse = client.createWebhook(parent, webhook);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockWebhooks.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateWebhookRequest actualRequest = ((CreateWebhookRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(webhook, actualRequest.getWebhook());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createWebhookExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockWebhooks.addException(exception);

    try {
      String parent = "parent-995424086";
      Webhook webhook = Webhook.newBuilder().build();
      client.createWebhook(parent, webhook);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updateWebhookTest() throws Exception {
    Webhook expectedResponse =
        Webhook.newBuilder()
            .setName(WebhookName.of("[PROJECT]", "[LOCATION]", "[AGENT]", "[WEBHOOK]").toString())
            .setDisplayName("displayName1714148973")
            .setTimeout(Duration.newBuilder().build())
            .setDisabled(true)
            .build();
    mockWebhooks.addResponse(expectedResponse);

    Webhook webhook = Webhook.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    Webhook actualResponse = client.updateWebhook(webhook, updateMask);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockWebhooks.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateWebhookRequest actualRequest = ((UpdateWebhookRequest) actualRequests.get(0));

    Assert.assertEquals(webhook, actualRequest.getWebhook());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateWebhookExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockWebhooks.addException(exception);

    try {
      Webhook webhook = Webhook.newBuilder().build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateWebhook(webhook, updateMask);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteWebhookTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockWebhooks.addResponse(expectedResponse);

    WebhookName name = WebhookName.of("[PROJECT]", "[LOCATION]", "[AGENT]", "[WEBHOOK]");

    client.deleteWebhook(name);

    List<AbstractMessage> actualRequests = mockWebhooks.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteWebhookRequest actualRequest = ((DeleteWebhookRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteWebhookExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockWebhooks.addException(exception);

    try {
      WebhookName name = WebhookName.of("[PROJECT]", "[LOCATION]", "[AGENT]", "[WEBHOOK]");
      client.deleteWebhook(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteWebhookTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockWebhooks.addResponse(expectedResponse);

    String name = "name3373707";

    client.deleteWebhook(name);

    List<AbstractMessage> actualRequests = mockWebhooks.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteWebhookRequest actualRequest = ((DeleteWebhookRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteWebhookExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockWebhooks.addException(exception);

    try {
      String name = "name3373707";
      client.deleteWebhook(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
