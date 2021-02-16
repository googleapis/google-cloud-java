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

package com.google.cloud.dialogflow.v2beta1;

import static com.google.cloud.dialogflow.v2beta1.ContextsClient.ListContextsPagedResponse;

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
import com.google.protobuf.Struct;
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
public class ContextsClientTest {
  private static MockServiceHelper mockServiceHelper;
  private static MockContexts mockContexts;
  private ContextsClient client;
  private LocalChannelProvider channelProvider;

  @BeforeClass
  public static void startStaticServer() {
    mockContexts = new MockContexts();
    mockServiceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(), Arrays.<MockGrpcService>asList(mockContexts));
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
  public void listContextsTest() throws Exception {
    Context responsesElement = Context.newBuilder().build();
    ListContextsResponse expectedResponse =
        ListContextsResponse.newBuilder()
            .setNextPageToken("")
            .addAllContexts(Arrays.asList(responsesElement))
            .build();
    mockContexts.addResponse(expectedResponse);

    SessionName parent = SessionName.ofProjectSessionName("[PROJECT]", "[SESSION]");

    ListContextsPagedResponse pagedListResponse = client.listContexts(parent);

    List<Context> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getContextsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockContexts.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListContextsRequest actualRequest = ((ListContextsRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listContextsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockContexts.addException(exception);

    try {
      SessionName parent = SessionName.ofProjectSessionName("[PROJECT]", "[SESSION]");
      client.listContexts(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listContextsTest2() throws Exception {
    Context responsesElement = Context.newBuilder().build();
    ListContextsResponse expectedResponse =
        ListContextsResponse.newBuilder()
            .setNextPageToken("")
            .addAllContexts(Arrays.asList(responsesElement))
            .build();
    mockContexts.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListContextsPagedResponse pagedListResponse = client.listContexts(parent);

    List<Context> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getContextsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockContexts.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListContextsRequest actualRequest = ((ListContextsRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listContextsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockContexts.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listContexts(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getContextTest() throws Exception {
    Context expectedResponse =
        Context.newBuilder()
            .setName(
                ContextName.ofProjectSessionContextName("[PROJECT]", "[SESSION]", "[CONTEXT]")
                    .toString())
            .setLifespanCount(1178775510)
            .setParameters(Struct.newBuilder().build())
            .build();
    mockContexts.addResponse(expectedResponse);

    ContextName name =
        ContextName.ofProjectSessionContextName("[PROJECT]", "[SESSION]", "[CONTEXT]");

    Context actualResponse = client.getContext(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockContexts.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetContextRequest actualRequest = ((GetContextRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getContextExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockContexts.addException(exception);

    try {
      ContextName name =
          ContextName.ofProjectSessionContextName("[PROJECT]", "[SESSION]", "[CONTEXT]");
      client.getContext(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getContextTest2() throws Exception {
    Context expectedResponse =
        Context.newBuilder()
            .setName(
                ContextName.ofProjectSessionContextName("[PROJECT]", "[SESSION]", "[CONTEXT]")
                    .toString())
            .setLifespanCount(1178775510)
            .setParameters(Struct.newBuilder().build())
            .build();
    mockContexts.addResponse(expectedResponse);

    String name = "name3373707";

    Context actualResponse = client.getContext(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockContexts.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetContextRequest actualRequest = ((GetContextRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getContextExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockContexts.addException(exception);

    try {
      String name = "name3373707";
      client.getContext(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createContextTest() throws Exception {
    Context expectedResponse =
        Context.newBuilder()
            .setName(
                ContextName.ofProjectSessionContextName("[PROJECT]", "[SESSION]", "[CONTEXT]")
                    .toString())
            .setLifespanCount(1178775510)
            .setParameters(Struct.newBuilder().build())
            .build();
    mockContexts.addResponse(expectedResponse);

    SessionName parent = SessionName.ofProjectSessionName("[PROJECT]", "[SESSION]");
    Context context = Context.newBuilder().build();

    Context actualResponse = client.createContext(parent, context);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockContexts.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateContextRequest actualRequest = ((CreateContextRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(context, actualRequest.getContext());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createContextExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockContexts.addException(exception);

    try {
      SessionName parent = SessionName.ofProjectSessionName("[PROJECT]", "[SESSION]");
      Context context = Context.newBuilder().build();
      client.createContext(parent, context);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createContextTest2() throws Exception {
    Context expectedResponse =
        Context.newBuilder()
            .setName(
                ContextName.ofProjectSessionContextName("[PROJECT]", "[SESSION]", "[CONTEXT]")
                    .toString())
            .setLifespanCount(1178775510)
            .setParameters(Struct.newBuilder().build())
            .build();
    mockContexts.addResponse(expectedResponse);

    String parent = "parent-995424086";
    Context context = Context.newBuilder().build();

    Context actualResponse = client.createContext(parent, context);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockContexts.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateContextRequest actualRequest = ((CreateContextRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(context, actualRequest.getContext());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createContextExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockContexts.addException(exception);

    try {
      String parent = "parent-995424086";
      Context context = Context.newBuilder().build();
      client.createContext(parent, context);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updateContextTest() throws Exception {
    Context expectedResponse =
        Context.newBuilder()
            .setName(
                ContextName.ofProjectSessionContextName("[PROJECT]", "[SESSION]", "[CONTEXT]")
                    .toString())
            .setLifespanCount(1178775510)
            .setParameters(Struct.newBuilder().build())
            .build();
    mockContexts.addResponse(expectedResponse);

    Context context = Context.newBuilder().build();

    Context actualResponse = client.updateContext(context);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockContexts.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateContextRequest actualRequest = ((UpdateContextRequest) actualRequests.get(0));

    Assert.assertEquals(context, actualRequest.getContext());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateContextExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockContexts.addException(exception);

    try {
      Context context = Context.newBuilder().build();
      client.updateContext(context);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updateContextTest2() throws Exception {
    Context expectedResponse =
        Context.newBuilder()
            .setName(
                ContextName.ofProjectSessionContextName("[PROJECT]", "[SESSION]", "[CONTEXT]")
                    .toString())
            .setLifespanCount(1178775510)
            .setParameters(Struct.newBuilder().build())
            .build();
    mockContexts.addResponse(expectedResponse);

    Context context = Context.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    Context actualResponse = client.updateContext(context, updateMask);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockContexts.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateContextRequest actualRequest = ((UpdateContextRequest) actualRequests.get(0));

    Assert.assertEquals(context, actualRequest.getContext());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateContextExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockContexts.addException(exception);

    try {
      Context context = Context.newBuilder().build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateContext(context, updateMask);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteContextTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockContexts.addResponse(expectedResponse);

    ContextName name =
        ContextName.ofProjectSessionContextName("[PROJECT]", "[SESSION]", "[CONTEXT]");

    client.deleteContext(name);

    List<AbstractMessage> actualRequests = mockContexts.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteContextRequest actualRequest = ((DeleteContextRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteContextExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockContexts.addException(exception);

    try {
      ContextName name =
          ContextName.ofProjectSessionContextName("[PROJECT]", "[SESSION]", "[CONTEXT]");
      client.deleteContext(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteContextTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockContexts.addResponse(expectedResponse);

    String name = "name3373707";

    client.deleteContext(name);

    List<AbstractMessage> actualRequests = mockContexts.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteContextRequest actualRequest = ((DeleteContextRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteContextExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockContexts.addException(exception);

    try {
      String name = "name3373707";
      client.deleteContext(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteAllContextsTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockContexts.addResponse(expectedResponse);

    SessionName parent = SessionName.ofProjectSessionName("[PROJECT]", "[SESSION]");

    client.deleteAllContexts(parent);

    List<AbstractMessage> actualRequests = mockContexts.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteAllContextsRequest actualRequest = ((DeleteAllContextsRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteAllContextsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockContexts.addException(exception);

    try {
      SessionName parent = SessionName.ofProjectSessionName("[PROJECT]", "[SESSION]");
      client.deleteAllContexts(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteAllContextsTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockContexts.addResponse(expectedResponse);

    String parent = "parent-995424086";

    client.deleteAllContexts(parent);

    List<AbstractMessage> actualRequests = mockContexts.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteAllContextsRequest actualRequest = ((DeleteAllContextsRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteAllContextsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockContexts.addException(exception);

    try {
      String parent = "parent-995424086";
      client.deleteAllContexts(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
