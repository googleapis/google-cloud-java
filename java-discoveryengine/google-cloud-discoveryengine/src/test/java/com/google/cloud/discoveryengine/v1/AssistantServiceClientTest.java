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

package com.google.cloud.discoveryengine.v1;

import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.grpc.testing.LocalChannelProvider;
import com.google.api.gax.grpc.testing.MockGrpcService;
import com.google.api.gax.grpc.testing.MockServiceHelper;
import com.google.api.gax.grpc.testing.MockStreamObserver;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.api.gax.rpc.ServerStreamingCallable;
import com.google.api.gax.rpc.StatusCode;
import io.grpc.StatusRuntimeException;
import java.io.IOException;
import java.util.Arrays;
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
}
