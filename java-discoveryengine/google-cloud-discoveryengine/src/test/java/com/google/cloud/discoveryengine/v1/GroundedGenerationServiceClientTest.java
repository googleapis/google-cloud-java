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
import com.google.api.gax.grpc.GaxGrpcProperties;
import com.google.api.gax.grpc.testing.LocalChannelProvider;
import com.google.api.gax.grpc.testing.MockGrpcService;
import com.google.api.gax.grpc.testing.MockServiceHelper;
import com.google.api.gax.grpc.testing.MockStreamObserver;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.ApiStreamObserver;
import com.google.api.gax.rpc.BidiStreamingCallable;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.api.gax.rpc.StatusCode;
import com.google.protobuf.AbstractMessage;
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
public class GroundedGenerationServiceClientTest {
  private static MockGroundedGenerationService mockGroundedGenerationService;
  private static MockLocations mockLocations;
  private static MockServiceHelper mockServiceHelper;
  private LocalChannelProvider channelProvider;
  private GroundedGenerationServiceClient client;

  @BeforeClass
  public static void startStaticServer() {
    mockGroundedGenerationService = new MockGroundedGenerationService();
    mockLocations = new MockLocations();
    mockServiceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(),
            Arrays.<MockGrpcService>asList(mockGroundedGenerationService, mockLocations));
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
    GroundedGenerationServiceSettings settings =
        GroundedGenerationServiceSettings.newBuilder()
            .setTransportChannelProvider(channelProvider)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = GroundedGenerationServiceClient.create(settings);
  }

  @After
  public void tearDown() throws Exception {
    client.close();
  }

  @Test
  public void streamGenerateGroundedContentTest() throws Exception {
    GenerateGroundedContentResponse expectedResponse =
        GenerateGroundedContentResponse.newBuilder()
            .addAllCandidates(new ArrayList<GenerateGroundedContentResponse.Candidate>())
            .build();
    mockGroundedGenerationService.addResponse(expectedResponse);
    GenerateGroundedContentRequest request =
        GenerateGroundedContentRequest.newBuilder()
            .setLocation(LocationName.of("[PROJECT]", "[LOCATION]").toString())
            .setSystemInstruction(GroundedGenerationContent.newBuilder().build())
            .addAllContents(new ArrayList<GroundedGenerationContent>())
            .setGenerationSpec(GenerateGroundedContentRequest.GenerationSpec.newBuilder().build())
            .setGroundingSpec(GenerateGroundedContentRequest.GroundingSpec.newBuilder().build())
            .putAllUserLabels(new HashMap<String, String>())
            .build();

    MockStreamObserver<GenerateGroundedContentResponse> responseObserver =
        new MockStreamObserver<>();

    BidiStreamingCallable<GenerateGroundedContentRequest, GenerateGroundedContentResponse>
        callable = client.streamGenerateGroundedContentCallable();
    ApiStreamObserver<GenerateGroundedContentRequest> requestObserver =
        callable.bidiStreamingCall(responseObserver);

    requestObserver.onNext(request);
    requestObserver.onCompleted();

    List<GenerateGroundedContentResponse> actualResponses = responseObserver.future().get();
    Assert.assertEquals(1, actualResponses.size());
    Assert.assertEquals(expectedResponse, actualResponses.get(0));
  }

  @Test
  public void streamGenerateGroundedContentExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockGroundedGenerationService.addException(exception);
    GenerateGroundedContentRequest request =
        GenerateGroundedContentRequest.newBuilder()
            .setLocation(LocationName.of("[PROJECT]", "[LOCATION]").toString())
            .setSystemInstruction(GroundedGenerationContent.newBuilder().build())
            .addAllContents(new ArrayList<GroundedGenerationContent>())
            .setGenerationSpec(GenerateGroundedContentRequest.GenerationSpec.newBuilder().build())
            .setGroundingSpec(GenerateGroundedContentRequest.GroundingSpec.newBuilder().build())
            .putAllUserLabels(new HashMap<String, String>())
            .build();

    MockStreamObserver<GenerateGroundedContentResponse> responseObserver =
        new MockStreamObserver<>();

    BidiStreamingCallable<GenerateGroundedContentRequest, GenerateGroundedContentResponse>
        callable = client.streamGenerateGroundedContentCallable();
    ApiStreamObserver<GenerateGroundedContentRequest> requestObserver =
        callable.bidiStreamingCall(responseObserver);

    requestObserver.onNext(request);

    try {
      List<GenerateGroundedContentResponse> actualResponses = responseObserver.future().get();
      Assert.fail("No exception thrown");
    } catch (ExecutionException e) {
      Assert.assertTrue(e.getCause() instanceof InvalidArgumentException);
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void generateGroundedContentTest() throws Exception {
    GenerateGroundedContentResponse expectedResponse =
        GenerateGroundedContentResponse.newBuilder()
            .addAllCandidates(new ArrayList<GenerateGroundedContentResponse.Candidate>())
            .build();
    mockGroundedGenerationService.addResponse(expectedResponse);

    GenerateGroundedContentRequest request =
        GenerateGroundedContentRequest.newBuilder()
            .setLocation(LocationName.of("[PROJECT]", "[LOCATION]").toString())
            .setSystemInstruction(GroundedGenerationContent.newBuilder().build())
            .addAllContents(new ArrayList<GroundedGenerationContent>())
            .setGenerationSpec(GenerateGroundedContentRequest.GenerationSpec.newBuilder().build())
            .setGroundingSpec(GenerateGroundedContentRequest.GroundingSpec.newBuilder().build())
            .putAllUserLabels(new HashMap<String, String>())
            .build();

    GenerateGroundedContentResponse actualResponse = client.generateGroundedContent(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockGroundedGenerationService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GenerateGroundedContentRequest actualRequest =
        ((GenerateGroundedContentRequest) actualRequests.get(0));

    Assert.assertEquals(request.getLocation(), actualRequest.getLocation());
    Assert.assertEquals(request.getSystemInstruction(), actualRequest.getSystemInstruction());
    Assert.assertEquals(request.getContentsList(), actualRequest.getContentsList());
    Assert.assertEquals(request.getGenerationSpec(), actualRequest.getGenerationSpec());
    Assert.assertEquals(request.getGroundingSpec(), actualRequest.getGroundingSpec());
    Assert.assertEquals(request.getUserLabelsMap(), actualRequest.getUserLabelsMap());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void generateGroundedContentExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockGroundedGenerationService.addException(exception);

    try {
      GenerateGroundedContentRequest request =
          GenerateGroundedContentRequest.newBuilder()
              .setLocation(LocationName.of("[PROJECT]", "[LOCATION]").toString())
              .setSystemInstruction(GroundedGenerationContent.newBuilder().build())
              .addAllContents(new ArrayList<GroundedGenerationContent>())
              .setGenerationSpec(GenerateGroundedContentRequest.GenerationSpec.newBuilder().build())
              .setGroundingSpec(GenerateGroundedContentRequest.GroundingSpec.newBuilder().build())
              .putAllUserLabels(new HashMap<String, String>())
              .build();
      client.generateGroundedContent(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void checkGroundingTest() throws Exception {
    CheckGroundingResponse expectedResponse =
        CheckGroundingResponse.newBuilder()
            .setSupportScore(-635385310)
            .addAllCitedChunks(new ArrayList<FactChunk>())
            .addAllCitedFacts(new ArrayList<CheckGroundingResponse.CheckGroundingFactChunk>())
            .addAllClaims(new ArrayList<CheckGroundingResponse.Claim>())
            .build();
    mockGroundedGenerationService.addResponse(expectedResponse);

    CheckGroundingRequest request =
        CheckGroundingRequest.newBuilder()
            .setGroundingConfig(
                GroundingConfigName.of("[PROJECT]", "[LOCATION]", "[GROUNDING_CONFIG]").toString())
            .setAnswerCandidate("answerCandidate-292402331")
            .addAllFacts(new ArrayList<GroundingFact>())
            .setGroundingSpec(CheckGroundingSpec.newBuilder().build())
            .putAllUserLabels(new HashMap<String, String>())
            .build();

    CheckGroundingResponse actualResponse = client.checkGrounding(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockGroundedGenerationService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CheckGroundingRequest actualRequest = ((CheckGroundingRequest) actualRequests.get(0));

    Assert.assertEquals(request.getGroundingConfig(), actualRequest.getGroundingConfig());
    Assert.assertEquals(request.getAnswerCandidate(), actualRequest.getAnswerCandidate());
    Assert.assertEquals(request.getFactsList(), actualRequest.getFactsList());
    Assert.assertEquals(request.getGroundingSpec(), actualRequest.getGroundingSpec());
    Assert.assertEquals(request.getUserLabelsMap(), actualRequest.getUserLabelsMap());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void checkGroundingExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockGroundedGenerationService.addException(exception);

    try {
      CheckGroundingRequest request =
          CheckGroundingRequest.newBuilder()
              .setGroundingConfig(
                  GroundingConfigName.of("[PROJECT]", "[LOCATION]", "[GROUNDING_CONFIG]")
                      .toString())
              .setAnswerCandidate("answerCandidate-292402331")
              .addAllFacts(new ArrayList<GroundingFact>())
              .setGroundingSpec(CheckGroundingSpec.newBuilder().build())
              .putAllUserLabels(new HashMap<String, String>())
              .build();
      client.checkGrounding(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
