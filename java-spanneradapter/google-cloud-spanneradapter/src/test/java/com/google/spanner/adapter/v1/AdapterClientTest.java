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

package com.google.spanner.adapter.v1;

import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.grpc.GaxGrpcProperties;
import com.google.api.gax.grpc.testing.LocalChannelProvider;
import com.google.api.gax.grpc.testing.MockGrpcService;
import com.google.api.gax.grpc.testing.MockServiceHelper;
import com.google.api.gax.grpc.testing.MockStreamObserver;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.api.gax.rpc.ServerStreamingCallable;
import com.google.api.gax.rpc.StatusCode;
import com.google.protobuf.AbstractMessage;
import com.google.protobuf.ByteString;
import io.grpc.StatusRuntimeException;
import java.io.IOException;
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
public class AdapterClientTest {
  private static MockAdapter mockAdapter;
  private static MockServiceHelper mockServiceHelper;
  private LocalChannelProvider channelProvider;
  private AdapterClient client;

  @BeforeClass
  public static void startStaticServer() {
    mockAdapter = new MockAdapter();
    mockServiceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(), Arrays.<MockGrpcService>asList(mockAdapter));
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
    AdapterSettings settings =
        AdapterSettings.newBuilder()
            .setTransportChannelProvider(channelProvider)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = AdapterClient.create(settings);
  }

  @After
  public void tearDown() throws Exception {
    client.close();
  }

  @Test
  public void createSessionTest() throws Exception {
    Session expectedResponse =
        Session.newBuilder()
            .setName(
                SessionName.of("[PROJECT]", "[INSTANCE]", "[DATABASE]", "[SESSION]").toString())
            .build();
    mockAdapter.addResponse(expectedResponse);

    DatabaseName parent = DatabaseName.of("[PROJECT]", "[INSTANCE]", "[DATABASE]");
    Session session = Session.newBuilder().build();

    Session actualResponse = client.createSession(parent, session);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAdapter.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateSessionRequest actualRequest = ((CreateSessionRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(session, actualRequest.getSession());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createSessionExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAdapter.addException(exception);

    try {
      DatabaseName parent = DatabaseName.of("[PROJECT]", "[INSTANCE]", "[DATABASE]");
      Session session = Session.newBuilder().build();
      client.createSession(parent, session);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createSessionTest2() throws Exception {
    Session expectedResponse =
        Session.newBuilder()
            .setName(
                SessionName.of("[PROJECT]", "[INSTANCE]", "[DATABASE]", "[SESSION]").toString())
            .build();
    mockAdapter.addResponse(expectedResponse);

    String parent = "parent-995424086";
    Session session = Session.newBuilder().build();

    Session actualResponse = client.createSession(parent, session);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAdapter.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateSessionRequest actualRequest = ((CreateSessionRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(session, actualRequest.getSession());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createSessionExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAdapter.addException(exception);

    try {
      String parent = "parent-995424086";
      Session session = Session.newBuilder().build();
      client.createSession(parent, session);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void adaptMessageTest() throws Exception {
    AdaptMessageResponse expectedResponse =
        AdaptMessageResponse.newBuilder()
            .setPayload(ByteString.EMPTY)
            .putAllStateUpdates(new HashMap<String, String>())
            .setLast(true)
            .build();
    mockAdapter.addResponse(expectedResponse);
    AdaptMessageRequest request =
        AdaptMessageRequest.newBuilder()
            .setName(
                SessionName.of("[PROJECT]", "[INSTANCE]", "[DATABASE]", "[SESSION]").toString())
            .setProtocol("protocol-989163880")
            .setPayload(ByteString.EMPTY)
            .putAllAttachments(new HashMap<String, String>())
            .build();

    MockStreamObserver<AdaptMessageResponse> responseObserver = new MockStreamObserver<>();

    ServerStreamingCallable<AdaptMessageRequest, AdaptMessageResponse> callable =
        client.adaptMessageCallable();
    callable.serverStreamingCall(request, responseObserver);

    List<AdaptMessageResponse> actualResponses = responseObserver.future().get();
    Assert.assertEquals(1, actualResponses.size());
    Assert.assertEquals(expectedResponse, actualResponses.get(0));
  }

  @Test
  public void adaptMessageExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAdapter.addException(exception);
    AdaptMessageRequest request =
        AdaptMessageRequest.newBuilder()
            .setName(
                SessionName.of("[PROJECT]", "[INSTANCE]", "[DATABASE]", "[SESSION]").toString())
            .setProtocol("protocol-989163880")
            .setPayload(ByteString.EMPTY)
            .putAllAttachments(new HashMap<String, String>())
            .build();

    MockStreamObserver<AdaptMessageResponse> responseObserver = new MockStreamObserver<>();

    ServerStreamingCallable<AdaptMessageRequest, AdaptMessageResponse> callable =
        client.adaptMessageCallable();
    callable.serverStreamingCall(request, responseObserver);

    try {
      List<AdaptMessageResponse> actualResponses = responseObserver.future().get();
      Assert.fail("No exception thrown");
    } catch (ExecutionException e) {
      Assert.assertTrue(e.getCause() instanceof InvalidArgumentException);
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }
}
