/*
 * Copyright 2026 Google LLC
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

package com.google.cloud.discoveryengine.v1beta;

import static com.google.cloud.discoveryengine.v1beta.AssistantServiceClient.ListAssistantsPagedResponse;

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
import com.google.common.collect.Lists;
import com.google.protobuf.AbstractMessage;
import com.google.protobuf.Empty;
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
public class AssistantServiceClientTest {
  private static MockAssistantService mockAssistantService;
  private static MockLocations mockLocations;
  private static MockServiceHelper mockServiceHelper;
  private LocalChannelProvider channelProvider;
  private AssistantServiceClient client;

  @BeforeClass
  public static void startStaticServer() {
    mockAssistantService = new MockAssistantService();
    mockLocations = new MockLocations();
    mockServiceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(),
            Arrays.<MockGrpcService>asList(mockAssistantService, mockLocations));
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
    AssistantServiceSettings settings =
        AssistantServiceSettings.newBuilder()
            .setTransportChannelProvider(channelProvider)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = AssistantServiceClient.create(settings);
  }

  @After
  public void tearDown() throws Exception {
    client.close();
  }

  @Test
  public void streamAssistTest() throws Exception {
    StreamAssistResponse expectedResponse =
        StreamAssistResponse.newBuilder()
            .setAnswer(AssistAnswer.newBuilder().build())
            .setSessionInfo(StreamAssistResponse.SessionInfo.newBuilder().build())
            .setAssistToken("assistToken-336502512")
            .addAllInvocationTools(new ArrayList<String>())
            .addAllInvokedSkills(new ArrayList<StreamAssistResponse.InvokedSkill>())
            .build();
    mockAssistantService.addResponse(expectedResponse);
    StreamAssistRequest request =
        StreamAssistRequest.newBuilder()
            .setName(
                AssistantName.of(
                        "[PROJECT]", "[LOCATION]", "[COLLECTION]", "[ENGINE]", "[ASSISTANT]")
                    .toString())
            .setQuery(Query.newBuilder().build())
            .setSession(
                SessionName.ofProjectLocationDataStoreSessionName(
                        "[PROJECT]", "[LOCATION]", "[DATA_STORE]", "[SESSION]")
                    .toString())
            .setUserMetadata(AssistUserMetadata.newBuilder().build())
            .setToolsSpec(StreamAssistRequest.ToolsSpec.newBuilder().build())
            .setGenerationSpec(StreamAssistRequest.GenerationSpec.newBuilder().build())
            .build();

    MockStreamObserver<StreamAssistResponse> responseObserver = new MockStreamObserver<>();

    ServerStreamingCallable<StreamAssistRequest, StreamAssistResponse> callable =
        client.streamAssistCallable();
    callable.serverStreamingCall(request, responseObserver);

    List<StreamAssistResponse> actualResponses = responseObserver.future().get();
    Assert.assertEquals(1, actualResponses.size());
    Assert.assertEquals(expectedResponse, actualResponses.get(0));
  }

  @Test
  public void streamAssistExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAssistantService.addException(exception);
    StreamAssistRequest request =
        StreamAssistRequest.newBuilder()
            .setName(
                AssistantName.of(
                        "[PROJECT]", "[LOCATION]", "[COLLECTION]", "[ENGINE]", "[ASSISTANT]")
                    .toString())
            .setQuery(Query.newBuilder().build())
            .setSession(
                SessionName.ofProjectLocationDataStoreSessionName(
                        "[PROJECT]", "[LOCATION]", "[DATA_STORE]", "[SESSION]")
                    .toString())
            .setUserMetadata(AssistUserMetadata.newBuilder().build())
            .setToolsSpec(StreamAssistRequest.ToolsSpec.newBuilder().build())
            .setGenerationSpec(StreamAssistRequest.GenerationSpec.newBuilder().build())
            .build();

    MockStreamObserver<StreamAssistResponse> responseObserver = new MockStreamObserver<>();

    ServerStreamingCallable<StreamAssistRequest, StreamAssistResponse> callable =
        client.streamAssistCallable();
    callable.serverStreamingCall(request, responseObserver);

    try {
      List<StreamAssistResponse> actualResponses = responseObserver.future().get();
      Assert.fail("No exception thrown");
    } catch (ExecutionException e) {
      Assert.assertTrue(e.getCause() instanceof InvalidArgumentException);
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void createAssistantTest() throws Exception {
    Assistant expectedResponse =
        Assistant.newBuilder()
            .setName(
                AssistantName.of(
                        "[PROJECT]", "[LOCATION]", "[COLLECTION]", "[ENGINE]", "[ASSISTANT]")
                    .toString())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .setGenerationConfig(Assistant.GenerationConfig.newBuilder().build())
            .setDefaultWebGroundingToggleOff(true)
            .putAllEnabledTools(new HashMap<String, Assistant.ToolList>())
            .setCustomerPolicy(Assistant.CustomerPolicy.newBuilder().build())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .build();
    mockAssistantService.addResponse(expectedResponse);

    CreateAssistantRequest request =
        CreateAssistantRequest.newBuilder()
            .setParent(
                EngineName.of("[PROJECT]", "[LOCATION]", "[COLLECTION]", "[ENGINE]").toString())
            .setAssistant(Assistant.newBuilder().build())
            .setAssistantId("assistantId-324518759")
            .build();

    Assistant actualResponse = client.createAssistant(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAssistantService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateAssistantRequest actualRequest = ((CreateAssistantRequest) actualRequests.get(0));

    Assert.assertEquals(request.getParent(), actualRequest.getParent());
    Assert.assertEquals(request.getAssistant(), actualRequest.getAssistant());
    Assert.assertEquals(request.getAssistantId(), actualRequest.getAssistantId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createAssistantExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAssistantService.addException(exception);

    try {
      CreateAssistantRequest request =
          CreateAssistantRequest.newBuilder()
              .setParent(
                  EngineName.of("[PROJECT]", "[LOCATION]", "[COLLECTION]", "[ENGINE]").toString())
              .setAssistant(Assistant.newBuilder().build())
              .setAssistantId("assistantId-324518759")
              .build();
      client.createAssistant(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteAssistantTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockAssistantService.addResponse(expectedResponse);

    AssistantName name =
        AssistantName.of("[PROJECT]", "[LOCATION]", "[COLLECTION]", "[ENGINE]", "[ASSISTANT]");

    client.deleteAssistant(name);

    List<AbstractMessage> actualRequests = mockAssistantService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteAssistantRequest actualRequest = ((DeleteAssistantRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteAssistantExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAssistantService.addException(exception);

    try {
      AssistantName name =
          AssistantName.of("[PROJECT]", "[LOCATION]", "[COLLECTION]", "[ENGINE]", "[ASSISTANT]");
      client.deleteAssistant(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteAssistantTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockAssistantService.addResponse(expectedResponse);

    String name = "name3373707";

    client.deleteAssistant(name);

    List<AbstractMessage> actualRequests = mockAssistantService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteAssistantRequest actualRequest = ((DeleteAssistantRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteAssistantExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAssistantService.addException(exception);

    try {
      String name = "name3373707";
      client.deleteAssistant(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updateAssistantTest() throws Exception {
    Assistant expectedResponse =
        Assistant.newBuilder()
            .setName(
                AssistantName.of(
                        "[PROJECT]", "[LOCATION]", "[COLLECTION]", "[ENGINE]", "[ASSISTANT]")
                    .toString())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .setGenerationConfig(Assistant.GenerationConfig.newBuilder().build())
            .setDefaultWebGroundingToggleOff(true)
            .putAllEnabledTools(new HashMap<String, Assistant.ToolList>())
            .setCustomerPolicy(Assistant.CustomerPolicy.newBuilder().build())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .build();
    mockAssistantService.addResponse(expectedResponse);

    Assistant assistant = Assistant.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    Assistant actualResponse = client.updateAssistant(assistant, updateMask);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAssistantService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateAssistantRequest actualRequest = ((UpdateAssistantRequest) actualRequests.get(0));

    Assert.assertEquals(assistant, actualRequest.getAssistant());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateAssistantExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAssistantService.addException(exception);

    try {
      Assistant assistant = Assistant.newBuilder().build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateAssistant(assistant, updateMask);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getAssistantTest() throws Exception {
    Assistant expectedResponse =
        Assistant.newBuilder()
            .setName(
                AssistantName.of(
                        "[PROJECT]", "[LOCATION]", "[COLLECTION]", "[ENGINE]", "[ASSISTANT]")
                    .toString())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .setGenerationConfig(Assistant.GenerationConfig.newBuilder().build())
            .setDefaultWebGroundingToggleOff(true)
            .putAllEnabledTools(new HashMap<String, Assistant.ToolList>())
            .setCustomerPolicy(Assistant.CustomerPolicy.newBuilder().build())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .build();
    mockAssistantService.addResponse(expectedResponse);

    AssistantName name =
        AssistantName.of("[PROJECT]", "[LOCATION]", "[COLLECTION]", "[ENGINE]", "[ASSISTANT]");

    Assistant actualResponse = client.getAssistant(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAssistantService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetAssistantRequest actualRequest = ((GetAssistantRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getAssistantExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAssistantService.addException(exception);

    try {
      AssistantName name =
          AssistantName.of("[PROJECT]", "[LOCATION]", "[COLLECTION]", "[ENGINE]", "[ASSISTANT]");
      client.getAssistant(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getAssistantTest2() throws Exception {
    Assistant expectedResponse =
        Assistant.newBuilder()
            .setName(
                AssistantName.of(
                        "[PROJECT]", "[LOCATION]", "[COLLECTION]", "[ENGINE]", "[ASSISTANT]")
                    .toString())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .setGenerationConfig(Assistant.GenerationConfig.newBuilder().build())
            .setDefaultWebGroundingToggleOff(true)
            .putAllEnabledTools(new HashMap<String, Assistant.ToolList>())
            .setCustomerPolicy(Assistant.CustomerPolicy.newBuilder().build())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .build();
    mockAssistantService.addResponse(expectedResponse);

    String name = "name3373707";

    Assistant actualResponse = client.getAssistant(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAssistantService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetAssistantRequest actualRequest = ((GetAssistantRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getAssistantExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAssistantService.addException(exception);

    try {
      String name = "name3373707";
      client.getAssistant(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listAssistantsTest() throws Exception {
    Assistant responsesElement = Assistant.newBuilder().build();
    ListAssistantsResponse expectedResponse =
        ListAssistantsResponse.newBuilder()
            .setNextPageToken("")
            .addAllAssistants(Arrays.asList(responsesElement))
            .build();
    mockAssistantService.addResponse(expectedResponse);

    EngineName parent = EngineName.of("[PROJECT]", "[LOCATION]", "[COLLECTION]", "[ENGINE]");

    ListAssistantsPagedResponse pagedListResponse = client.listAssistants(parent);

    List<Assistant> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getAssistantsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockAssistantService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListAssistantsRequest actualRequest = ((ListAssistantsRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listAssistantsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAssistantService.addException(exception);

    try {
      EngineName parent = EngineName.of("[PROJECT]", "[LOCATION]", "[COLLECTION]", "[ENGINE]");
      client.listAssistants(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listAssistantsTest2() throws Exception {
    Assistant responsesElement = Assistant.newBuilder().build();
    ListAssistantsResponse expectedResponse =
        ListAssistantsResponse.newBuilder()
            .setNextPageToken("")
            .addAllAssistants(Arrays.asList(responsesElement))
            .build();
    mockAssistantService.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListAssistantsPagedResponse pagedListResponse = client.listAssistants(parent);

    List<Assistant> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getAssistantsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockAssistantService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListAssistantsRequest actualRequest = ((ListAssistantsRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listAssistantsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAssistantService.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listAssistants(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
